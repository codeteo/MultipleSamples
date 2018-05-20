package com.examples.di.builder

import com.examples.di.ActivityScope
import com.examples.features.main.MainActivity
import com.examples.features.main.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindsMainActivity(): MainActivity

}