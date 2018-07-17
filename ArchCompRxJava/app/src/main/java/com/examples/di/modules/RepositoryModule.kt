package com.examples.di.modules

import com.examples.domain.ReposRepository
import com.examples.mylibrary.GithubApi
import com.examples.mylibrary.feature.repos.ReposRepositoryImpl
import com.examples.mylibrary.mappers.ReposModelMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by teo on 19/7/2018.
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesStatusRepository(githubApi: GithubApi,
                                 mapper: ReposModelMapper):
            ReposRepository = ReposRepositoryImpl(githubApi, mapper)
}