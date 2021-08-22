package com.example.lesson2homework

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

//Практическое задание 1 - вытащить кэширование в отдельный класс
//RoomRepositoriesCache и внедрить его сюда через интерфейс IRepositoriesCache
class RetrofitGithubRepositoriesRepo(val api: IDataSource2, val networkStatus:
INetworkStatus, val db: Database,val repocache:IRepositoriesCache) : IGithubRepositoriesRepo {
    override fun getRepositories(login:String) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getRepositories("$login")
                .flatMap { repositories ->
                            Single.fromCallable {
                                val roomUser = login?.let {
                                    db.userDao.findByLogin(it) } ?: throw RuntimeException("No such user in cache")
                                repocache.cache(roomUser.id,repositories)
                                repositories
                            }
                        }

            } else {
                Single.fromCallable {
                    val roomUser = login?.let { db.userDao.findByLogin(it) } ?:
                    throw RuntimeException("No such user in cache")
                    db.repositoryDao.findForUser(roomUser.id!!).map {
                        GithubRepo(it.id.toInt(),it.name, it.privateb,it.forksCount) }
                }
            }
        }.subscribeOn(Schedulers.io())
}