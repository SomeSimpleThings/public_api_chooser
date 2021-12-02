package com.somethingsimple.core_impl.di.module

import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource
import com.somethingsimple.core_impl.datasource.publicapi.LocalPublicApiDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [DbModule::class])
interface LocalDataSourceModule {

    @Binds
    @Singleton
    fun bindPublicApiLocalDataSource(
        localPublicApiDataSourceImpl: LocalPublicApiDataSourceImpl
    ): LocalPublicApiDataSource

}