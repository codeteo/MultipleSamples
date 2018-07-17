package com.examples.di.modules

import com.examples.mylibrary.mappers.ReposModelMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by teo on 19/7/2018.
 */

@Module
class MappersModule {

    @Provides
    @Singleton
    fun provideReposMapper() = ReposModelMapper()

}