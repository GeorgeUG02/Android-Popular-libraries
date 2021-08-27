package com.example.courseproject

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class SchedulerModule {
    @Singleton
    @Provides
    fun uiScheduler()= AndroidSchedulers.mainThread()
}