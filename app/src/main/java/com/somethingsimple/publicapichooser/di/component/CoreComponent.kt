package com.somethingsimple.publicapichooser.di.component

import android.app.Application
import com.somethingsimple.core.CoreProviderFactory
import com.somethingsimple.core_api.di.provider.*
import dagger.Component


@Component(
    dependencies = [
        LocalDataSourceProvider::class,
        NetworkDataSourceProvider::class,
        AppPrefsProvider::class,
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
                .appPrefsProvider(CoreProviderFactory.createAppPrefsProvider(appComponent))
                .build()

        }
    }
}