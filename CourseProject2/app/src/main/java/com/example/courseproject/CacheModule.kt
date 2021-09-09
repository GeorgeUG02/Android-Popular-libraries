package com.example.courseproject

import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Singleton
    @Provides
    fun provideDatabase(app: App): Database = Room.databaseBuilder(app,
        Database::class.java, Database.DB_NAME)
        .build()
    @Provides
    fun provideGamesCache(database: Database): IGamesCache =
        RoomGamesCache(database)
    @Provides
    fun provideGameDescriptionCache(database: Database): IGameDescriptionCache =
        RoomGameDescriptionCache(database)
}