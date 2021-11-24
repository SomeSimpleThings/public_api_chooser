package com.somethingsimple.core

import com.somethingsimple.core_api.di.provider.NavigationProvider
import com.somethingsimple.core_api.di.provider.NetworkDataSourceProvider
import com.somethingsimple.core_impl.di.component.DaggerNavigationComponent
import com.somethingsimple.core_impl.di.component.DaggerNetworkComponent

object CoreProviderFactory {

    private var networkProvider: NetworkDataSourceProvider? = null
    private var navigationProvider: NavigationProvider? = null

    fun createNetworkProvider(): NetworkDataSourceProvider {
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