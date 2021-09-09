package com.example.courseproject

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
@AddToEndSingle
interface ListView : MvpView {
    fun init()
    fun updateList()
}