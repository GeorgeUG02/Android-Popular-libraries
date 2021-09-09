package com.example.courseproject

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ViewModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindGamesFragment(): GamesFragment

    @ContributesAndroidInjector
    fun bindGameDescriptionFragment(): GameDescriptionFragment
}