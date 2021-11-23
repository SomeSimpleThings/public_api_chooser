package com.somethingsimple.core

import com.somethingsimple.core_api.di.provider.NetworkProvider
import com.somethingsimple.core_impl.component.DaggerNetworkComponent

object CoreProviderFactory {

    private var networkProvider: NetworkProvider? = null

    fun createNetworkProvider(): NetworkProvider {
        return networkProvider ?: DaggerNetworkComponent.builder().build().apply {
            networkProvider = this
        }
    }
}