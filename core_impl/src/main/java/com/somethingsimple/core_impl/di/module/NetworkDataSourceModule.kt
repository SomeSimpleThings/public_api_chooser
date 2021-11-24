package com.somethingsimple.core_impl.di.module

import com.somethingsimple.core_api.datasource.category.CategoryDataSource
import com.somethingsimple.core_api.datasource.category.remote.RemoteCategoryDataSource
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.remote.RemotePublicApiDataSource
import dagger.Binds
import dagger.Module


@Module(includes = [NetworkModule::class])
abstract class NetworkDataSourceModule {

    @Binds
    abstract fun bindCategoryNetworkDataSource(remoteCategoryDataSource: RemoteCategoryDataSource): CategoryDataSource

    @Binds
    abstract fun bindPublicApiNetworkDataSource(remotePublicApiDataSource: RemotePublicApiDataSource): PublicApiDataSource
}