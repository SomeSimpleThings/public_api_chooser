package com.somethingsimple.feature_api_details.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.viewmodel.ViewModelFactory
import com.somethingsimple.core_api.viewmodel.ViewModelKey
import com.somethingsimple.feature_api_details.data.ApiDetailsRepository
import com.somethingsimple.feature_api_details.data.ApiDetailsRepositoryImpl
import com.somethingsimple.feature_api_details.domain.ApiDetailsUseCase
import com.somethingsimple.feature_api_details.ui.ApiDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ApiDetailsModule {

    @Binds
    @ApiDetailsScope
    abstract fun bindApiRepository(apiRepositoryImpl: ApiDetailsRepositoryImpl): ApiDetailsRepository

    @Binds
    @ApiDetailsScope
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Module
    companion object {
        @Provides
        @ApiDetailsScope
        @IntoMap
        @ViewModelKey(ApiDetailsViewModel::class)
        fun provideApiListViewModel(apisUseCase: ApiDetailsUseCase): ViewModel =
            ApiDetailsViewModel(apisUseCase)
    }

}
