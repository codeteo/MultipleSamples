package com.examples.domain

/**
 * Maps data items from the data layer to the domain layer.
 */

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO
}