package com.examples.features.main.di

import com.examples.di.ActivityScope
import com.examples.features.main.MainActivity
import com.examples.features.main.MainMVP
import com.examples.features.main.MainPresenter
import dagger.Binds
import dagger.Module

/**
 * Dagger module for [MainActivity].
 */

@Module
abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract fun providesMainPresenter(presenter: MainPresenter): MainMVP.Presenter

    @ActivityScope
    @Binds
    abstract fun providesMainActivity(activity: MainActivity): MainMVP.View

}