package com.example.lesson2homework

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun usersRepo(api: IDataSource,database: Database, networkStatus: INetworkStatus, userCache:
    IUserCache): IGithubUsersRepo = RetrofitGithubUsersRepo(api,
        networkStatus,database, userCache)
    @Singleton
    @Provides
    fun repositoriesRepo(api2:IDataSource2,database:Database,networkStatus: INetworkStatus,repositoriesCache:IRepositoriesCache):IGithubRepositoriesRepo =
        RetrofitGithubRepositoriesRepo(api2,networkStatus,database,repositoriesCache)
}