package com.example.lesson2homework

import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubRepo (val api: IDataSource2): IGithubRepo {
        override fun getRepo(login:String) = api.loadUserRepo(login).subscribeOn(Schedulers.io())
    }