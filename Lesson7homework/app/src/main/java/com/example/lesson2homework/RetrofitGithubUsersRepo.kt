package com.example.lesson2homework

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

//Практическое задание 1 - вытащить кэширование в отдельный класс
//RoomUserCache и внедрить его сюда через интерфейс IUserCache
class RetrofitGithubUsersRepo(val api: IDataSource, val networkStatus:
INetworkStatus, val db: Database,val usercache:IUserCache) : IGithubUsersRepo {
    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline
       ->
        if (isOnline) {
            api.getUsers()
                .flatMap { users ->
                    Single.fromCallable {
                        usercache.cache(users)
                        users
                    }
                }
        } else {
            Single.fromCallable {
                db.userDao.getAll().map { roomUser ->
                    GithubUser(roomUser.id, roomUser.login, roomUser.avatarUrl)
                }
            }
        }
    }.subscribeOn(Schedulers.io())
}