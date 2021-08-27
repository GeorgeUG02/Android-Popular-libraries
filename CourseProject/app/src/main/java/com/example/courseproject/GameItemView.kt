package com.example.courseproject

interface GameItemView: IItemView {
    fun setName(name: String)
    fun setReleasedDate(date: String)
    fun loadImage(url:String)
    fun setRating(rating:Double)
}