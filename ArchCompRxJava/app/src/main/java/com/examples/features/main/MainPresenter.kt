package com.examples.features.main

import com.examples.utils.schedulers.BaseSchedulerProvider
import timber.log.Timber
import javax.inject.Inject

/**
 * Presenter for [MainActivity].
 */

class MainPresenter
    @Inject constructor(
                val view: MainMVP.View,
                val schedulerProvider: BaseSchedulerProvider
    ) : MainMVP.Presenter {

    override fun onLoadData() {
        Timber.i("ON LOAD DATA")
    }

}