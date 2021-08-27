package com.example.courseproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomGame (
    @PrimaryKey var id: Int,
    var name:String?,
    var released:String?,
    var background_image:String?,
    var rating:Double?
)