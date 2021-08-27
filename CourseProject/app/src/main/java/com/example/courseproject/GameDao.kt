package com.example.courseproject

import androidx.room.*

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(game: RoomGame)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(games: List<RoomGame>)
    @Update fun update(game: RoomGame)
    @Delete fun delete(game: RoomGame)
    @Query("SELECT * FROM RoomGame")
    fun getAll(): List<RoomGame>
    @Query("SELECT * FROM RoomGame WHERE id = :gameId")
    fun findForGame(gameId:Int): RoomGame
}