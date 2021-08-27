package com.example.courseproject

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class GamesPresenter() :
    MvpPresenter<ListView>() {
    @Inject lateinit var gamesRepo: IGamesRepo
    @Inject lateinit var router: Router
    @Inject lateinit var screens: AndroidScreens
    @Inject lateinit var uiScheduler: Scheduler
    class GamesListPresenter : IGamesListPresenter {
        val games = mutableListOf<Game>()
        override var itemClickListener: ((GameItemView) -> Unit)? = null
        override fun getCount() = games.size
        override fun bindView(view: GameItemView) {
            val game = games[view.pos]
            game.name?.let{view.setName(it)}
            game.released?.let{view.setReleasedDate(it)}
            game.background_image?.let{view.loadImage(it)}
            game.rating?.let{view.setRating(it)}
        }
    }

    val gamesListPresenter = GamesListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        gamesListPresenter.itemClickListener = { itemView ->
            router.navigateTo(screens.gameDescription(gamesListPresenter.games[itemView.pos].id))

        }
    }
    fun loadData() {
        gamesRepo.getGames()
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                gamesListPresenter.games.clear()
                gamesListPresenter.games.addAll(repos.results!!)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}