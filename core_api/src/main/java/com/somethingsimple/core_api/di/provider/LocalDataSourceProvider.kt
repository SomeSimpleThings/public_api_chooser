package com.somethingsimple.core_api.di.provider

import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource

interface LocalDataSourceProvider {

    fun provideLocalPublicApiDataSource(): LocalPublicApiDataSource
}