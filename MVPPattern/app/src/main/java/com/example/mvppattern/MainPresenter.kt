package com.example.mvppattern

class MainPresenter(val view: MainView) {
    val model = CountersModel()
    fun counterClick(index: Int){
        when(index){
            0 -> {
                val nextValue = model.next(0)
                view.setButton1Text(nextValue.toString())
            }
            1 -> {
                val nextValue = model.next(1)
                view.setButton2Text(nextValue.toString())
            }
            2-> {
                val nextValue = model.next(2)
                view.setButton3Text(nextValue.toString())
            }
        }
    }
}