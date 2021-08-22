package com.example.lesson2homework

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [RoomGithubUser::class,
    RoomGithubRepository::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repositoryDao: RepositoryDao
    companion object {
        const val DB_NAME = "database.db"
    }
}