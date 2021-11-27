package com.somethingsimple.feature_api_list.di

import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.feature_api_list.ui.ApisFragment
import dagger.Component


@ApiListFeatureScope
@Component(
    dependencies = [CoreProvider::class],
    modules = [ApiListModule::class]
)
interface ApiListComponent {

    companion object {
        fun create(coreProvider: CoreProvider): ApiListComponent {
            return DaggerApiListComponent
                .builder()
                .coreProvider(coreProvider)
                .build()
        }
    }


    fun inject(apisFragment: ApisFragment)
}