package com.example.lesson2homework

import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Singleton
    @Provides
    fun database(app: App): Database = Room.databaseBuilder(app,
        Database::class.java, Database.DB_NAME)
        .build()
    @Singleton
    @Provides
    fun usersCache(database: Database): IUserCache =
        RoomUserCache(database)
    @Singleton
    @Provides
    fun repositoriesCache(database: Database): IRepositoriesCache =
        RoomRepositoriesCache(database)
}