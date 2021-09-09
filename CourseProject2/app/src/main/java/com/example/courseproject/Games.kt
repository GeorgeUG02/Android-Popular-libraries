package com.example.courseproject

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Games(
    @Expose val results: List<Game>? = null
) : Parcelable

@Parcelize
data class Game(
     @Expose val id:Int?=null,
     @Expose val name:String?=null,
     @Expose val released:String?=null,
     @Expose val background_image:String?=null,
     @Expose val rating:Double?=null
) : Parcelable