package com.somethingsimple.core_api.di.provider

import com.somethingsimple.core_api.datasource.category.local.LocalCategoryDataSource
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSource

interface LocalDataSourceProvider {

    fun provideLocalCategoryDataSource(): LocalCategoryDataSource
    fun provideLocalPublicApiDataSource(): LocalPublicApiDataSource
}