package com.example.courseproject

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
    fun gamesCache(database: Database): IGamesCache =
        RoomGamesCache(database)
    @Singleton
    @Provides
    fun gameDescriptionCache(database: Database): IGameDescriptionCache =
        RoomGameDescriptionCache(database)
}