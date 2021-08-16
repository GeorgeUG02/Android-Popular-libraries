package com.example.lesson2homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson2homework.databinding.FragmentUserBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment() : MvpAppCompatFragment() {
    private var vb: FragmentUserBinding? = null
    private var adapter:RepoRVAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb?.textView?.text=arguments?.getString("user")
            val githubRepo = RetrofitGithubRepo(ApiHolder.api2)
            val s: Single<List<GithubRepo>> =
                githubRepo.getRepo(arguments?.getString("user")!!)
            s.observeOn(AndroidSchedulers.mainThread()).subscribe({
                repos->
                vb?.rvRepos?.layoutManager = LinearLayoutManager(context)
                adapter= RepoRVAdapter(repos)
                vb?.rvRepos?.adapter=adapter
            },
                {println("Error: ${it.message}")})


    }
}