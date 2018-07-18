package com.examples.mylibrary.mappers

import com.examples.mylibrary.getRepo
import com.examples.mylibrary.getRepoItem
import org.assertj.core.api.SoftAssertions
import org.junit.Test

/**
 * Created by teo on 20/7/2018.
 */

class ReposModelMapperTest {

    private val mapper = ReposModelMapper()

    @Test
    fun shouldMapRepoItemToRepo() {
        // given
        val repoItem = getRepoItem()
        val expectedRepo = getRepo()

        // when
        val mapResult = mapper.map(repoItem)

        // then
        SoftAssertions().apply {
            assertThat(mapResult.id).isEqualTo(expectedRepo.id)
            assertThat(mapResult.name).isEqualTo(expectedRepo.name)
        }.assertAll()
    }

}