package com.somethingsimple.publicapichooser.di.module.publicapi

import com.somethingsimple.core_api.data.db.PublicApiDao
import com.somethingsimple.core_api.data.network.PublicApi
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSourceImpl
import com.somethingsimple.core_api.datasource.publicapi.remote.RemotePublicApiDataSource
import com.somethingsimple.publicapichooser.data.repository.publicapi.PublicApiRepository
import com.somethingsimple.publicapichooser.data.repository.publicapi.PublicApiRepositoryImpl
import com.somethingsimple.publicapichooser.di.module.DbModule
import com.somethingsimple.publicapichooser.di.module.NetworkModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [PublicApiUiModule::class, NetworkModule::class, DbModule::class])
class PublicApiModule {
    @Singleton
    @Provides
    fun providePublicApiRepository(
        remotePublicApiDataSource: PublicApiDataSource,
        localPublicApiDataSource: LocalPublicApiDataSource
    ): PublicApiRepository =
        PublicApiRepositoryImpl(remotePublicApiDataSource, localPublicApiDataSource)

    @Singleton
    @Provides
    fun provideRemotePublicApiDataSource(publicApisApi: PublicApi): PublicApiDataSource =
        RemotePublicApiDataSource(publicApisApi)

    @Singleton
    @Provides
    fun provideLocalPublicAPiDataSource(dao: PublicApiDao): LocalPublicApiDataSource =
        LocalPublicApiDataSourceImpl(dao)
}