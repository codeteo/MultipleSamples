package com.examples.features.main

/**
 * Contract class between View and Presenter for [MainActivity].
 */

interface MainMVP {

    interface View {

        fun showData()

        fun showProgressBar()

        fun hideProgressBar()

    }

    interface Presenter {

        fun onLoadData()

    }

}