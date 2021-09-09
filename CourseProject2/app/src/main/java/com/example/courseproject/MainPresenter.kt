package com.example.courseproject

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter(val router: Router,val screens:AndroidScreens) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.games())
    }
    fun backClicked() {
        router.exit()
    }
}