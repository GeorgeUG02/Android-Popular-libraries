package com.example.lesson4homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson4homework.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private var vb: ActivityMainBinding? = null
    private val presenter=MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        presenter.load(File(applicationContext.filesDir,"a.jpg"),vb?.imageView!!).subscribe({
            println("onComplete")
        }, {
            println("onError: ${it.message}")
        })
        vb?.button?.setOnClickListener {
            presenter.convert(applicationContext.filesDir,"a.jpg").subscribe({
                println("onComplete")
            }, {
                println("onError: ${it.message}")
            })
        }

    }
}