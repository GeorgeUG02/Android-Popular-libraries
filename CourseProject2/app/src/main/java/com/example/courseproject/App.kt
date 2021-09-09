package com.example.courseproject

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class App : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {  }
    }
    override fun applicationInjector(): AndroidInjector<App> =
        DaggerApplicationComponent
            .builder()
            .withApp(this)
            .build()
}