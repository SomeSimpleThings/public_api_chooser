package com.somethingsimple.core_impl.di.component

import com.somethingsimple.core_api.di.provider.AppPrefsProvider
import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.core_impl.di.module.AppPrefsModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [AppPrefsModule::class]
)
interface AppPrefsComponent : AppPrefsProvider {
}