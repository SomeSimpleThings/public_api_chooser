package com.somethingsimple.publicapichooser.di.component

import android.app.Application
import com.somethingsimple.core.CoreProviderFactory
import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.core_api.di.provider.NavigationProvider
import com.somethingsimple.core_api.di.provider.NetworkDataSourceProvider
import dagger.Component


@Component(
    dependencies = [NetworkDataSourceProvider::class, AppProvider::class, NavigationProvider::class]
)
interface CoreComponent : CoreProvider {

    companion object {
        fun create(application: Application): CoreComponent {

            return DaggerCoreComponent
                .builder()
                .appProvider(AppComponent.create(application))
                .networkDataSourceProvider(CoreProviderFactory.createNetworkProvider())
                .navigationProvider(CoreProviderFactory.createNavigationProvider())
                .build()

        }
    }
}