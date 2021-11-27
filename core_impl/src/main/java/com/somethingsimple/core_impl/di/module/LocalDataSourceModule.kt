package com.somethingsimple.core_impl.di.module

import com.somethingsimple.core_api.data.db.CategoryDao
import com.somethingsimple.core_api.data.db.PublicApiDao
import com.somethingsimple.core_api.datasource.category.local.LocalCategoryDataSource
import com.somethingsimple.core_api.datasource.category.local.LocalCategoryDataSourceImpl
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DbModule::class])
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun bindCategoryLocalDataSource(categoryDao: CategoryDao): LocalCategoryDataSource =
        LocalCategoryDataSourceImpl(categoryDao)

    @Provides
    @Singleton
    fun bindPublicApiLocalDataSource(publicApiDao: PublicApiDao): LocalPublicApiDataSource =
        LocalPublicApiDataSourceImpl(publicApiDao)
}