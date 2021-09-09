package com.example.courseproject

import io.reactivex.rxjava3.core.Single

interface IGameDescriptionRepo {
    fun getGameDescription(id:Int): Single<GameDescription>
}