package com.example.courseproject

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import javax.inject.Inject

class GameDescriptionPresenter(val id:Int,val gameDescriptionRepo:IGameDescriptionRepo,val router:Router,val uiScheduler:Scheduler) :
    MvpPresenter<GDView>() {
    lateinit var disposable: Disposable
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }
    fun loadData() {
        disposable=gameDescriptionRepo.getGameDescription(id)
            .observeOn(uiScheduler)
            .subscribe({ gamedescription ->
                viewState.init(gamedescription)
            }, {
                println("Error: ${it.message}")
            })
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}