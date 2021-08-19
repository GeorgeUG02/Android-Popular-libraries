package com.example.lesson2homework

import io.reactivex.rxjava3.core.Single


class GithubUsersRepo {
    fun createJust() : Single<List<GithubUser>> {
        return Single.just(listOf(GithubUser("login1"), GithubUser("login2"), GithubUser("login3"), GithubUser("login4"), GithubUser("login5")))
    }
}