package com.example.courseproject

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    CiceroneModule::class,
    CacheModule::class,
    ApiModule::class,
    RepoModule::class,
    SchedulerModule::class,
    ViewModule::class
])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withApp(app:App): Builder
        fun build(): ApplicationComponent

    }

}