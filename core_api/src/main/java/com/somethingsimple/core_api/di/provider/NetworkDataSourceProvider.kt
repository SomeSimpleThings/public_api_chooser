package com.somethingsimple.core_api.di.provider

import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource

interface NetworkDataSourceProvider {

    fun provideRemotePublicApiDataSource(): PublicApiDataSource
}