package com.example.courseproject

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class GameDescriptionPresenter(val id:Int) :
    MvpPresenter<GDView>() {
    @Inject lateinit var gameDescriptionRepo: IGameDescriptionRepo
    @Inject lateinit var router: Router
    @Inject lateinit var uiScheduler: Scheduler

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }
    fun loadData() {
        gameDescriptionRepo.getGameDescription(id)
            .observeOn(uiScheduler)
            .subscribe({ gamedescription ->
                viewState.init(gamedescription)
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}