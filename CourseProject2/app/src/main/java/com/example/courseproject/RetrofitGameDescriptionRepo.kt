package com.example.courseproject

import com.example.courseproject.BuildConfig
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGameDescriptionRepo(val api: IDataSource2, val networkStatus:
INetworkStatus, val db: Database, val gameDescriptionCache:IGameDescriptionCache) : IGameDescriptionRepo {
    override fun getGameDescription(id:Int) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getGameDescription(id, BuildConfig.GAMES_API_KEY)
                .flatMap { gamedescription ->
                            Single.fromCallable {
                                gameDescriptionCache.cache(id,gamedescription)
                                gamedescription
                            }
                        }

            } else {
                Single.fromCallable {
                    val gd=db.gameDescriptionDao.findForGame(id)
                        GameDescription(gd.name,gd.description,gd.metacritic)
                }
            }
        }.subscribeOn(Schedulers.io())
}