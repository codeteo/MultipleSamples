package com.examples.features.main

import com.examples.mylibrary.GithubApi
import com.examples.utils.schedulers.BaseSchedulerProvider
import javax.inject.Inject

/**
 * Presenter for [MainActivity].
 */

class MainPresenter
    @Inject constructor(
                val view: MainMVP.View,
                val service: GithubApi,
                val schedulerProvider: BaseSchedulerProvider
    ) : MainMVP.Presenter {

    override fun onLoadData() {
        service.search("Retrofit")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe()
    }

}