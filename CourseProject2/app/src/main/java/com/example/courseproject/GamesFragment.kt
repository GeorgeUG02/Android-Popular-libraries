package com.example.courseproject

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseproject.databinding.FragmentGamesBinding
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.ktx.moxyPresenter
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class GamesFragment : AbsFragment(R.layout.fragment_games), ListView {
    companion object {
        fun newInstance(): Fragment = GamesFragment()
    }
    @Inject
    lateinit var gamesRepo: IGamesRepo
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: AndroidScreens
    @Inject
    lateinit var uiScheduler: Scheduler
    private val presenter: GamesPresenter by moxyPresenter {
        GamesPresenter(gamesRepo,router,screens,uiScheduler)
    }
    private var adapter: GamesRVAdapter? = null
    private val vb: FragmentGamesBinding by viewBinding()
    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = GamesRVAdapter(presenter.gamesListPresenter, GlideImageLoader())
        vb?.rvUsers?.adapter = adapter
    }
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

}