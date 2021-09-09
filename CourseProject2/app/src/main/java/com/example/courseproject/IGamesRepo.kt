package com.example.courseproject

import io.reactivex.rxjava3.core.Single

interface IGamesRepo {
    fun getGames(): Single<Games>
}