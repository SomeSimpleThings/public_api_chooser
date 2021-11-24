package com.somethingsimple.core_impl.di.component

import com.somethingsimple.core_api.di.provider.NavigationProvider
import com.somethingsimple.core_impl.di.module.NavigationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface NavigationComponent : NavigationProvider {
}