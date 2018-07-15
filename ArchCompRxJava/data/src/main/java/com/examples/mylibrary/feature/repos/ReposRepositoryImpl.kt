package com.examples.mylibrary.feature.repos

import com.examples.domain.ReposRepository
import com.examples.domain.model.Repo
import com.examples.mylibrary.GithubApi
import com.examples.mylibrary.mappers.ReposModelMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * Concrete implementation of [ReposRepository].
 */

class ReposRepositoryImpl @Inject constructor(
        private val githubApi: GithubApi,
        private val mapper: ReposModelMapper
) : ReposRepository {

    override fun getLinesStatus(): Single<List<Repo>> {
        return githubApi.search("Retrofit")
                .map {
                    if (it.isSuccessful) {
                        val repos = mutableListOf<Repo>()
                        it.body()?.items?.forEachIndexed { index, repoItem ->
                            repos.add(mapper.map(repoItem))
                        }
                        return@map repos
                    } else {
                        return@map emptyList<Repo>()
                    }
                }
    }

}