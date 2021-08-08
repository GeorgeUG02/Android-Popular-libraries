package com.example.lesson2homework

import io.reactivex.rxjava3.core.Observable


class GithubUsersRepo {
    fun createJust() : Observable<GithubUser> {
        return Observable.just(GithubUser("login1"), GithubUser("login2"), GithubUser("login3"), GithubUser("login4"), GithubUser("login5"))
    }
}