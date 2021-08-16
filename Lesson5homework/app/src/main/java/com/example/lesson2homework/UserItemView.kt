package com.example.lesson2homework

interface UserItemView: IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}