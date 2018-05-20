package com.examples.di

import javax.inject.Scope

/**
 * Scope for Activities and Fragments.
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope