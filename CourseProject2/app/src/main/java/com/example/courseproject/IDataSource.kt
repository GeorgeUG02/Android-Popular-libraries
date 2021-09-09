package com.example.courseproject

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface IDataSource {
        @GET("/api/games")
        fun getGames(@Query("key") api_key:String): Single<Games>
    }