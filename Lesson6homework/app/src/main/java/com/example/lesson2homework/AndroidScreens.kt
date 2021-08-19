package com.example.lesson2homework

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AndroidScreens {
    fun users() = FragmentScreen { UsersFragment.newInstance() }
    fun user(login:String?)=FragmentScreen {UserFragment().apply {
        val b: Bundle = Bundle()
        b.putString("user",login)
        arguments=b
    }}
}