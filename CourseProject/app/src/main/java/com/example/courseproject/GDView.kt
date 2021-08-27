package com.example.courseproject

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface GDView:MvpView {
    fun init(gameDescription: GameDescription)
}