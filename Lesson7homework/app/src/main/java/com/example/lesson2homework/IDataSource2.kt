package com.example.lesson2homework

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface IDataSource2 {
    @GET("/users/{login}/repos")
    fun getRepositories(@Path("login") login: String): Single<List<GithubRepo>>
}