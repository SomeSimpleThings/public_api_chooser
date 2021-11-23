package com.somethingsimple.publicapichooser.di.component

import android.app.Application
import com.somethingsimple.core.CoreProviderFactory
import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.core_api.di.provider.NavigationProvider
import com.somethingsimple.core_api.di.provider.NetworkProvider
import dagger.Component


@Component(
    dependencies = [NetworkProvider::class, AppProvider::class, NavigationProvider::class]
)
interface CoreComponent : CoreProvider {

    companion object {
        fun create(application: Application): CoreComponent {

            return DaggerCoreComponent
                .builder()
                .appProvider(AppComponent.create(application))
                .networkProvider(CoreProviderFactory.createNetworkProvider())
                .navigationProvider(CoreProviderFactory.createNavigationProvider())
                .build()

        }
    }
}