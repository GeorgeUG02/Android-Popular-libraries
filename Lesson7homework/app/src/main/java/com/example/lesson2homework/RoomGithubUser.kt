package com.example.lesson2homework

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomGithubUser(
    @PrimaryKey var id: String,
    var login: String,
    var avatarUrl: String
)