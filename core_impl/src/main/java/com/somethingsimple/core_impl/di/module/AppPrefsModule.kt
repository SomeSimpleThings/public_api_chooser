package com.somethingsimple.core_impl.di.module

import com.somethingsimple.core_api.datasource.AppPrefsDataSource
import com.somethingsimple.core_impl.datasource.AppPrefsDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AppPrefsModule {

    @Binds
    @Singleton
    fun bindAppPrefsDataSource(
        appPrefsDataSourceImpl: AppPrefsDataSourceImpl
    ): AppPrefsDataSource

}