package com.somethingsimple.publicapichooser.di.component

import android.app.Application
import com.somethingsimple.core.CoreProviderFactory
import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.core_api.di.provider.LocalDataSourceProvider
import com.somethingsimple.core_api.di.provider.NetworkDataSourceProvider
import dagger.Component


@Component(
    dependencies = [
        LocalDataSourceProvider::class,
        NetworkDataSourceProvider::class,
        AppProvider::class]
)
interface CoreComponent : CoreProvider {

    companion object {
        fun create(application: Application): CoreComponent {


            val appComponent = AppComponent.create(application)
            return DaggerCoreComponent
                .builder()
                .appProvider(appComponent)
                .networkDataSourceProvider(CoreProviderFactory.createNetworkProvider())
                .localDataSourceProvider(CoreProviderFactory.createLocalDSProvider(appComponent))
                .build()

        }
    }
}