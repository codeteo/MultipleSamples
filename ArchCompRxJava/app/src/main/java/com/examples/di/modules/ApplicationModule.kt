package com.examples.di.modules

import android.content.Context
import com.examples.Constants
import com.examples.MyApplication
import com.examples.utils.BaseUrlInterceptor
import com.examples.utils.NetworkUtils
import com.examples.utils.schedulers.BaseSchedulerProvider
import com.examples.utils.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import javax.inject.Singleton

/**
 * Dagger module building dependencies with Application scope.
 */

@Module
class ApplicationModule {

    private val PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL)!!

    @Provides
    @Singleton
    fun providesContext(app: MyApplication): Context = app.applicationContext

    @Provides
    @Singleton
    fun providesBaseUrl(): HttpUrl {
        return PRODUCTION_API_BASE_URL
    }

    @Provides
    @Singleton
    fun providesBaseUrlInterceptor(baseUrl: HttpUrl): BaseUrlInterceptor {
        return BaseUrlInterceptor(baseUrl.toString())
    }

    @Provides
    @Singleton
    fun providesNetworkUtils(context: Context): NetworkUtils {
        return NetworkUtils(context)
    }

    @Provides
    @Singleton
    fun providesSchedulers(): BaseSchedulerProvider {
        return SchedulerProvider.instance
    }

}