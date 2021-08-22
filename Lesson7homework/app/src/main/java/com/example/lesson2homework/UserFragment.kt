package com.example.lesson2homework

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson2homework.databinding.FragmentUserBinding
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class UserFragment() : MvpAppCompatFragment(),ListView,BackButtonListener {
    companion object {
        private const val USER_ARG = "user"
        fun newInstance(login:String) = UserFragment().apply {
            arguments = Bundle().apply {
                putString(USER_ARG, login)
            }
        }
    }
    private var vb: FragmentUserBinding? = null
    val presenter: UserPresenter by moxyPresenter {
        UserPresenter(arguments?.getString(USER_ARG)!!).apply {
            App.instance.appComponent.inject(this)
        }
    }
    private var adapter:RepoRVAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun init() {
        vb?.textView?.text=arguments?.getString(USER_ARG)
        vb?.rvRepos?.layoutManager = LinearLayoutManager(context)
        adapter = RepoRVAdapter(presenter.repoListPresenter)
        vb?.rvRepos?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}