package com.example.lesson2homework

import io.reactivex.rxjava3.core.Single

interface IGithubRepo {
    fun getRepo(login:String): Single<List<GithubRepo>>
}