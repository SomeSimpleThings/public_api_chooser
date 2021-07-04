package com.somethingsimple.publicapichooser.di.module

import android.content.Context
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.data.api.PublicApisApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providePublicApisApi(context: Context): PublicApisApi =
        Retrofit.Builder()
            .baseUrl(context.getString(R.string.public_api_url))
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PublicApisApi::class.java)

}