package com.somethingsimple.core_api.di.provider

import retrofit2.Retrofit

interface NetworkProvider {

    fun provideRetrofit(): Retrofit
}