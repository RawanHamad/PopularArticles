package com.example.populararticles.di.module

import android.app.Application
import android.content.Context
import com.example.populararticles.BuildConfig.API_KEY
import com.example.populararticles.BuildConfig.BASE_URL
import com.example.populararticles.di.module.viewmodel.ViewModelModule
import com.example.populararticles.utils.AuthInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(application: Application): Context = application


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder().baseUrl(BASE_URL).client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        application: Application, httpLoggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: AuthInterceptor
    ): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        val cacheDir = File(application.cacheDir, UUID.randomUUID().toString())
        val cache = Cache(cacheDir, 10 * 1024 * 1024)
        return okHttpClientBuilder.cache(cache)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    internal fun provideApiKeyInterceptor(): AuthInterceptor {
        return AuthInterceptor(API_KEY)
    }


    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


}

