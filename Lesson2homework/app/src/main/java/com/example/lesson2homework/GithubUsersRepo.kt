package com.example.lesson2homework

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )
    fun getUsers() : List<GithubUser> {
        return repositories
    }
}