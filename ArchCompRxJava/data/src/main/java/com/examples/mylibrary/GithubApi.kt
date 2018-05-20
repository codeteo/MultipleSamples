package com.examples.mylibrary

import com.examples.mylibrary.models.SearchRepositoryResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface
 */

interface GithubApi {

    @GET("/search/repositories")
    fun search(@Query("q") query: String): Observable<Response<SearchRepositoryResponse>>

}