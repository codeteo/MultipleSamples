package com.examples.mylibrary.feature.repos

import com.examples.domain.ReposRepository
import com.examples.mylibrary.GithubApi
import com.examples.mylibrary.getRepo
import com.examples.mylibrary.getRepoItem
import com.examples.mylibrary.mappers.ReposModelMapper
import com.examples.mylibrary.models.SearchRepositoryResponse
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import retrofit2.Response

/**
 * Unit tests for [ReposRepositoryImpl].
 */

class ReposRepositoryImplTest {

    private val mockGithubApi = mock<GithubApi>()
    private lateinit var reposRepository: ReposRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        reposRepository = ReposRepositoryImpl(mockGithubApi, ReposModelMapper())
    }

    @Test
    fun shouldReturnThrowableWhenItFailsToFetchLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockGithubApi.search(any())).thenReturn(Single.error(throwable))

        // when
        val testObserver = reposRepository.getRepos().test()

        // then
        testObserver.assertError(throwable)
        verify(mockGithubApi).search(any())
    }

    @Test
    fun shouldReturnReposWhenSuccess() {
        // given
        whenever(mockGithubApi.search(any()))
                .thenReturn(Single.just(
                        Response.success(SearchRepositoryResponse(10, false,
                                listOf(getRepoItem(), getRepoItem())
                        ))))

        // when
        val testObserver = reposRepository.getRepos().test()

        // then
        testObserver.assertNoErrors()
        testObserver.assertValue {
            it[0].id === getRepo().id
        }
        verify(mockGithubApi).search(any())
    }
}