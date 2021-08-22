package com.example.lesson2homework

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AndroidScreens {
    fun users() = FragmentScreen { UsersFragment.newInstance() }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun user(login:String?)=FragmentScreen {UserFragment.newInstance(login!!)}
}