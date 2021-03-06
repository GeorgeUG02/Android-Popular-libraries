package com.example.mvppattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvppattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private var vb: ActivityMainBinding? = null
    val presenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        val listener1 = View.OnClickListener {
            presenter.counterClick(0)
        }
        val listener2 = View.OnClickListener {
            presenter.counterClick(1)
        }
        val listener3 = View.OnClickListener {
            presenter.counterClick(2)
        }
        vb?.btnCounter1?.setOnClickListener(listener1)
        vb?.btnCounter2?.setOnClickListener(listener2)
        vb?.btnCounter3?.setOnClickListener(listener3)
    }
    override fun setButton1Text(text: String){
        vb?.btnCounter1?.text = text
    }
    override fun setButton2Text(text: String){
        vb?.btnCounter2?.text = text
    }
    override fun setButton3Text(text: String){
        vb?.btnCounter3?.text = text
    }
}