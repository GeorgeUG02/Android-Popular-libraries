package com.example.courseproject

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}