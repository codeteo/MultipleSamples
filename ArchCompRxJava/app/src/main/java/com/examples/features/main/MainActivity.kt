package com.examples.features.main

import android.os.Bundle
import com.examples.R
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainMVP.View {

    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.i("BEFORE")
        presenter.onLoadData()
        Timber.i("AFTER")
    }

    override fun showData() {

    }

    override fun showProgressBar() {

    }

    override fun hideProgressBar() {

    }

}
