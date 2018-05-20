package com.examples.mylibrary.models

import com.google.gson.annotations.SerializedName

/**
 * Models the responses for search requests.
 */

data class SearchRepositoryResponse(

        @SerializedName("total_count")
        var totalCount: Int?,

        @SerializedName("incomplete_results")
        var incompleteResults: Boolean?,

        @SerializedName("items")
        val items: List<RepoItem>
)

data class RepoItem(

        @SerializedName("score")
        val score: Double?,

        @SerializedName("owner")
        val owner: Owner,


        @SerializedName("description")
        val description: String
)


data class Owner(

        @SerializedName("id")
        val id: String,

        @SerializedName("avatar_url")
        val avatarUrl: String?,

        @SerializedName("login")
        val login: String?,

        @SerializedName("following_url")
        val followingUrl: String?,

        @SerializedName("followers_url")
        val followersUrl: String?

)