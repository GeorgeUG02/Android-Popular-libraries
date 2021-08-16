package com.example.lesson4homework

import android.widget.ImageView
import coil.api.load
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File
import java.lang.Exception

class MainPresenter {
    fun load(file:File,view:ImageView)=Completable.create { emitter ->
        try {
            view.load(file)
            emitter.onComplete()
        }
        catch (exception:Exception){
            emitter.onError(RuntimeException("Error"))
            return@create
        }
    }.subscribeOn(Schedulers.newThread())
    fun convert(filepath:File?,file:String)=
        Completable.create { emitter ->
            try {
                val f= File(filepath,file)
                val fn=File(filepath,"a.png")
                f.copyTo(fn)
                emitter.onComplete()
            }
            catch (exception:Exception){
                emitter.onError(RuntimeException("Error"))
                return@create
            }
        }.subscribeOn(Schedulers.newThread())

}