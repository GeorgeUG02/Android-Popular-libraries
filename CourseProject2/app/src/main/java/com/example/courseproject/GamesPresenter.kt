package com.example.courseproject

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import javax.inject.Inject

class GamesPresenter(val gamesRepo: IGamesRepo,val router: Router,val screens: AndroidScreens,val uiScheduler: Scheduler) :
    MvpPresenter<ListView>() {
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
    lateinit var disposable:Disposable
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        gamesListPresenter.itemClickListener = { itemView ->
            if (gamesListPresenter.games[itemView.pos].id!=null) {
                val id:Int=gamesListPresenter.games[itemView.pos].id?:0
                router.navigateTo(screens.gameDescription(id))
            }

        }
    }
    fun loadData() {
        disposable=gamesRepo.getGames()
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                gamesListPresenter.games.clear()
                gamesListPresenter.games.addAll(repos.results!!)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}