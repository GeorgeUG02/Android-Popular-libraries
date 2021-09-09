package com.example.courseproject

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AndroidScreens {
    fun games() = FragmentScreen { GamesFragment.newInstance() }
    fun gameDescription(id:Int)=FragmentScreen {GameDescriptionFragment.newInstance(id)}
}