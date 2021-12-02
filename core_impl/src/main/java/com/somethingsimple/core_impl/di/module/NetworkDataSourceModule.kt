package com.somethingsimple.core_impl.di.module

import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.core_impl.datasource.publicapi.RemotePublicApiDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
interface NetworkDataSourceModule {

    @Binds
    @Singleton
    fun bindPublicApiNetworkDataSource(
        remotePublicApiDataSource: RemotePublicApiDataSourceImpl
    ): PublicApiDataSource
}