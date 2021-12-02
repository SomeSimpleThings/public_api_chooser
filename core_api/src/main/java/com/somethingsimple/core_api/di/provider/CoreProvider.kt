package com.somethingsimple.core_api.di.provider

interface CoreProvider : LocalDataSourceProvider,
    NetworkDataSourceProvider, AppPrefsProvider {
}