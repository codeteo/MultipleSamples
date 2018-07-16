package com.examples.mylibrary.di

import com.examples.mylibrary.Constants
import com.examples.mylibrary.GithubApi
import com.examples.mylibrary.utils.BaseUrlInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Provides network dependencies with app scope.
 */

@Module
class NetworkModule {

    companion object {
        private val PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL)!!
        private const val CONNECTION_TIMEOUT = 15
    }

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
    fun providesOkHttpClient(baseUrlInterceptor: BaseUrlInterceptor): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
        client.retryOnConnectionFailure(true)
        client.addInterceptor(interceptor)
        client.addInterceptor(baseUrlInterceptor)
        client.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)

        return client.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl: HttpUrl, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesGithubApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }
}
