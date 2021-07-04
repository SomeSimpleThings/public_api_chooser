package com.somethingsimple.publicapichooser.di.module.publicapi

import com.somethingsimple.publicapichooser.data.api.PublicApisApi
import com.somethingsimple.publicapichooser.data.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.publicapichooser.data.datasource.publicapi.local.LocalPublicApiDataSource
import com.somethingsimple.publicapichooser.data.datasource.publicapi.local.LocalPublicApiDataSourceImpl
import com.somethingsimple.publicapichooser.data.datasource.publicapi.remote.RemotePublicApiDataSource
import com.somethingsimple.publicapichooser.data.db.ApiChooserDb
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
    fun provideRemotePublicApiDataSource(publicApisApi: PublicApisApi): PublicApiDataSource =
        RemotePublicApiDataSource(publicApisApi)

    @Singleton
    @Provides
    fun provideLocalPublicAPiDataSource(db: ApiChooserDb): LocalPublicApiDataSource =
        LocalPublicApiDataSourceImpl(db)
}