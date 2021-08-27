package com.example.lesson2homework

interface RepoItemView:IItemView {
    fun setName(name:String)
    fun setPrivate(privateb:Boolean)
    fun setForks(forks_count:Int)
}