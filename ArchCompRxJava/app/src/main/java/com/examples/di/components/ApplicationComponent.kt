package com.examples.di.components

import com.examples.MyApplication
import com.examples.di.builder.ActivityBuilder
import com.examples.di.modules.ApplicationModule
import com.examples.di.modules.InteractorsModule
import com.examples.di.modules.MappersModule
import com.examples.di.modules.RepositoryModule
import com.examples.mylibrary.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Dagger component.
 */

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            NetworkModule::class,
            ActivityBuilder::class,
            RepositoryModule::class,
            MappersModule::class,
            InteractorsModule::class]
)
interface ApplicationComponent {

    fun inject(app: MyApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: MyApplication) : Builder

        fun build(): ApplicationComponent
    }


}