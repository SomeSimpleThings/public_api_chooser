package com.somethingsimple.core_api.di.provider

import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSource

interface LocalDataSourceProvider {

    fun provideLocalPublicApiDataSource(): LocalPublicApiDataSource
}