package com.example.courseproject

import androidx.room.RoomDatabase

@androidx.room.Database(entities = [RoomGame::class,
    RoomGameDescription::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val gameDao: GameDao
    abstract val gameDescriptionDao: GameDescriptionDao
    companion object {
        const val DB_NAME = "database.db"
    }
}