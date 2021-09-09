package com.example.courseproject

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameDescription(
    @Expose val name: String? = null,
    @Expose val description: String? = null,
    @Expose val metacritic:Double? = null
) : Parcelable