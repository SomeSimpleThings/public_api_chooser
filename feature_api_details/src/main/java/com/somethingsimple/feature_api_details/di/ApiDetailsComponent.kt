package com.somethingsimple.feature_api_details.di

import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.feature_api_details.ui.ApiDetailsFragment
import dagger.Component

@Component(dependencies = [CoreProvider::class], modules = [ApiDetailsModule::class])
@ApiDetailsScope
interface ApiDetailsComponent {

    companion object {
        fun create(coreProvider: CoreProvider): ApiDetailsComponent {
            return DaggerApiDetailsComponent
                .builder()
                .coreProvider(coreProvider)
                .build()
        }
    }

    fun inject(apiDetailsFragment: ApiDetailsFragment)
}