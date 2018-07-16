package com.examples.domain

import com.examples.domain.model.Repo
import io.reactivex.Single

interface ReposRepository {

    fun getLinesStatus(): Single<List<Repo>>

}