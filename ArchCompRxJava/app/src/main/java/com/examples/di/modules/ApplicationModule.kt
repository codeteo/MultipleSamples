package com.examples.di.modules

import android.content.Context
import com.examples.MyApplication
import com.examples.utils.NetworkUtils
import com.examples.utils.schedulers.BaseSchedulerProvider
import com.examples.utils.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module building dependencies with Application scope.
 */

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun providesContext(app: MyApplication): Context = app.applicationContext

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