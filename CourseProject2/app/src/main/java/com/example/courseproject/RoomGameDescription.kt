package com.example.courseproject

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomGame::class,
        parentColumns = ["id"],
        childColumns = ["id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomGameDescription (
    @PrimaryKey var id: Int,
    var name:String?,
    var description:String?,
    var metacritic:Double?,
)