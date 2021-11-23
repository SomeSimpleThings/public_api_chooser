package com.somethingsimple.core_api.di.provider

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface NavigationProvider {

    fun provideCicerone(): Cicerone<Router>
    fun provideRouter(): Router
    fun provideNavHolder(): NavigatorHolder
}