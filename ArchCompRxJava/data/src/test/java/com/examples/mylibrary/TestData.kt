package com.examples.mylibrary

import com.examples.domain.model.Repo
import com.examples.mylibrary.models.Owner
import com.examples.mylibrary.models.RepoItem

/**
 * Created by teo on 20/7/2018.
 */

fun getRepoItem(): RepoItem {
    return RepoItem(
            score = 10.0,
            owner = Owner("100", null, "Teo", null, null),
            description = "some description"
    )
}

fun getRepo(): Repo {
    return Repo(
            id = "100",
            name = "Teo"
    )
}
