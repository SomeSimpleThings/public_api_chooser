package com.somethingsimple.core

import com.somethingsimple.core_api.di.provider.NavigationProvider
import com.somethingsimple.core_api.di.provider.NetworkProvider
import com.somethingsimple.core_impl.component.DaggerNavigationComponent
import com.somethingsimple.core_impl.component.DaggerNetworkComponent

object CoreProviderFactory {

    private var networkProvider: NetworkProvider? = null
    private var navigationProvider: NavigationProvider? = null

    fun createNetworkProvider(): NetworkProvider {
        return networkProvider ?: DaggerNetworkComponent.builder().build().apply {
            networkProvider = this
        }
    }

    fun createNavigationProvider(): NavigationProvider {
        return navigationProvider ?: DaggerNavigationComponent.builder().build().apply {
            navigationProvider = this
        }
    }
}