package com.example.courseproject

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseproject.databinding.FragmentGameBinding
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.ktx.moxyPresenter
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class GameDescriptionFragment() : AbsFragment(R.layout.fragment_game),GDView {
    companion object {
        private const val GAME_ARG = "game"
        fun newInstance(id:Int): Fragment = GameDescriptionFragment().apply {
            arguments = bundleOf( Pair(GAME_ARG,id))
        }
    }
    @Inject
    lateinit var gameDescriptionRepo: IGameDescriptionRepo
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var uiScheduler: Scheduler
    private val vb: FragmentGameBinding by viewBinding()
    private val presenter: GameDescriptionPresenter by moxyPresenter {
        val id:Int=arguments?.getInt(GAME_ARG)?:0
        GameDescriptionPresenter(id,gameDescriptionRepo,router,uiScheduler)
    }

    override fun init(gameDescription: GameDescription) {
        vb?.textView?.text="${gameDescription.name}\n${gameDescription.description}\n${gameDescription.metacritic}"
    }
}