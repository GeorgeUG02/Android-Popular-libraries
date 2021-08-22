package com.example.lesson2homework

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router
    @Inject lateinit var screens: AndroidScreens
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }
    fun backClicked() {
        router.exit()
    }
}