package com.example.courseproject

import androidx.room.*
@Dao
interface GameDescriptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(game: RoomGameDescription)
    @Update fun update(game: RoomGameDescription)
    @Delete fun delete(game: RoomGameDescription)
    @Query("SELECT * FROM RoomGameDescription WHERE id = :gameId")
    fun findForGame(gameId:Int): RoomGameDescription
}