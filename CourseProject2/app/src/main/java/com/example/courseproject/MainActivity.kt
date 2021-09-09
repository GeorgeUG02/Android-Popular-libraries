package com.example.courseproject

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseproject.R
import com.example.courseproject.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : AbsActivity(R.layout.activity_main), MainView {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    val navigator = AppNavigator(this, R.id.container)
    @Inject
    lateinit var router: Router
    @Inject lateinit var screens: AndroidScreens
    private val presenter by moxyPresenter { MainPresenter(router,screens)}
    private val vb: ActivityMainBinding by viewBinding()
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
    override fun onBackPressed() {
        presenter.backClicked()
    }
}