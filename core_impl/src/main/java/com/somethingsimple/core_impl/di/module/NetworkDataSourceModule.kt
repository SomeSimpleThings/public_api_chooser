package com.somethingsimple.core_impl.di.module

import com.somethingsimple.core_api.datasource.category.CategoryDataSource
import com.somethingsimple.core_api.datasource.category.remote.RemoteCategoryDataSource
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.remote.RemotePublicApiDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
abstract class NetworkDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindCategoryNetworkDataSource(remoteCategoryDataSource: RemoteCategoryDataSource): CategoryDataSource

    @Binds
    @Singleton
    abstract fun bindPublicApiNetworkDataSource(remotePublicApiDataSource: RemotePublicApiDataSource): PublicApiDataSource
}