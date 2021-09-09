package com.example.courseproject

import com.example.courseproject.BuildConfig
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class RetrofitGamesRepo(val api: IDataSource, val networkStatus:
INetworkStatus, val db: Database, val gamescache:IGamesCache) : IGamesRepo {
    override fun getGames() = networkStatus.isOnlineSingle().flatMap { isOnline
       ->
        if (isOnline) {
            api.getGames(BuildConfig.GAMES_API_KEY)
                .flatMap { games ->
                    Single.fromCallable {
                        gamescache.cache(games)
                        games
                    }
                }
        } else {
            Single.fromCallable {
                val games=db.gameDao.getAll().map { roomGame ->
                    Game(roomGame.id, roomGame.name, roomGame.released,roomGame.background_image,roomGame.rating)
                }
                Games(games)
            }
        }
    }.subscribeOn(Schedulers.io())
}