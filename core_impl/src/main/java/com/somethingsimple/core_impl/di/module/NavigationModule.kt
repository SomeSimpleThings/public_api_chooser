package com.somethingsimple.core_impl.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Singleton
    @Provides
    fun provideCicerone() = Cicerone.create()

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Singleton
    @Provides
    fun provideNavHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
}