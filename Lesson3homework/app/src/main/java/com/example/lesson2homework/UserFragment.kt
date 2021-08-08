package com.example.lesson2homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson2homework.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment

class UserFragment: MvpAppCompatFragment() {
    private var vb: FragmentUserBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb?.textView?.text=arguments?.getString("user")
    }
}