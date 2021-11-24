package com.somethingsimple.core_impl.di.component

import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.core_api.di.provider.LocalDataSourceProvider
import com.somethingsimple.core_impl.di.module.LocalDataSourceModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [LocalDataSourceModule::class],
    dependencies = [AppProvider::class]
)
interface LocalDataSourceComponent : LocalDataSourceProvider