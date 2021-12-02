package com.somethingsimple.core_api.di.provider

import com.somethingsimple.core_api.datasource.AppPrefsDataSource

interface AppPrefsProvider {
    fun provideAppPrefsDataSource(): AppPrefsDataSource
}