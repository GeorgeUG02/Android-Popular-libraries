package com.example.lesson2homework

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubRepo(
    @Expose val full_name:String,
    @Expose val private:Boolean,
    @Expose val forks:Int
): Parcelable