package com.example.lesson2homework

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}