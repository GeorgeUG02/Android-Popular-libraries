package com.example.lesson2homework

interface IRepositoriesCache {
    fun cache(id:String,repositories: List<GithubRepo>)
}