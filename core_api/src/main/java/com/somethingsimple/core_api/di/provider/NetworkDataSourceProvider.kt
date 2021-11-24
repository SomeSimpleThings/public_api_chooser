package com.somethingsimple.core_api.di.provider

import com.somethingsimple.core_api.datasource.category.CategoryDataSource
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource

interface NetworkDataSourceProvider {

    fun provideRemoteCategoryDataSource(): CategoryDataSource
    fun provideRemotePublicApiDataSource(): PublicApiDataSource
}