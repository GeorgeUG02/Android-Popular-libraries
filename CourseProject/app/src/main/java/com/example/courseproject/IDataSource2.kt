package com.example.courseproject

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface IDataSource2 {
    @GET("/api/games/{id}")
    fun getGameDescription(@Path("id") id: Int,@Query("key") api_key:String): Single<GameDescription>
}