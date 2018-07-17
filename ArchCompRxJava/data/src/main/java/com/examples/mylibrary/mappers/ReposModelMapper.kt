package com.examples.mylibrary.mappers

import com.examples.domain.Mapper
import com.examples.domain.model.Repo
import com.examples.mylibrary.models.RepoItem

/**
 * Created by teo on 16/7/2018.
 */
class ReposModelMapper : Mapper<RepoItem, Repo> {

    override fun map(from: RepoItem): Repo {
        return Repo(
                id = from.description,
                name = from.owner.login!!
        )
    }

}