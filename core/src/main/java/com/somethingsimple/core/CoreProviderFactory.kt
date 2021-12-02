package com.somethingsimple.core

import com.somethingsimple.core_api.di.provider.AppPrefsProvider
import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.core_api.di.provider.LocalDataSourceProvider
import com.somethingsimple.core_api.di.provider.NetworkDataSourceProvider
import com.somethingsimple.core_impl.di.component.DaggerAppPrefsComponent
import com.somethingsimple.core_impl.di.component.DaggerLocalDataSourceComponent
import com.somethingsimple.core_impl.di.component.DaggerNetworkDataSourceComponent

object CoreProviderFactory {

    private var networkDataSourceProvider: NetworkDataSourceProvider? = null
    private var localDataSourceProvider: LocalDataSourceProvider? = null
    private var appPrefsProvider: AppPrefsProvider? = null

    fun createNetworkProvider(): NetworkDataSourceProvider {
        return networkDataSourceProvider ?: DaggerNetworkDataSourceComponent
            .builder()
            .build()
            .apply {
                networkDataSourceProvider = this
            }
    }

    fun createLocalDSProvider(appProvider: AppProvider): LocalDataSourceProvider {
        return localDataSourceProvider ?: DaggerLocalDataSourceComponent
            .builder()
            .appProvider(appProvider)
            .build().apply {
                localDataSourceProvider = this
            }
    }

    fun createAppPrefsProvider(appProvider: AppProvider): AppPrefsProvider {
        return appPrefsProvider ?: DaggerAppPrefsComponent
            .builder()
            .appProvider(appProvider)
            .build().apply {
                appPrefsProvider = this
            }
    }
}