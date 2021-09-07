package com.example.courseproject

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun gamesRepo(api: IDataSource,database: Database, networkStatus: INetworkStatus, gamesCache:
    IGamesCache): IGamesRepo = RetrofitGamesRepo(api,
        networkStatus,database, gamesCache)
    @Singleton
    @Provides
    fun gameDescriptionRepo(api2:IDataSource2,database:Database,networkStatus: INetworkStatus,gameDescriptionCache:IGameDescriptionCache):IGameDescriptionRepo =
        RetrofitGameDescriptionRepo(api2,networkStatus,database,gameDescriptionCache)
}