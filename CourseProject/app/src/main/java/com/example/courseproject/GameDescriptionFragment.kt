package com.example.courseproject

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.courseproject.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class GameDescriptionFragment() : MvpAppCompatFragment(),GDView,BackButtonListener {
    companion object {
        private const val GAME_ARG = "game"
        fun newInstance(id:Int) = GameDescriptionFragment().apply {
            arguments = Bundle().apply {
                putInt(GAME_ARG, id)
            }
        }
    }
    private var vb: FragmentUserBinding? = null
    val presenter: GameDescriptionPresenter by moxyPresenter {
        GameDescriptionPresenter(arguments?.getInt(GAME_ARG)!!).apply {
            App.instance.appComponent.inject(this)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun init(gameDescription: GameDescription) {
        vb?.textView?.text="${gameDescription.name}\n${gameDescription.description}\n${gameDescription.metacritic}"
    }


    override fun backPressed() = presenter.backPressed()
}