package com.somethingsimple.feature_api_list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.viewmodel.ViewModelFactory
import com.somethingsimple.core_api.viewmodel.ViewModelKey
import com.somethingsimple.feature_api_list.data.repo.PublicApiRepository
import com.somethingsimple.feature_api_list.data.repo.PublicApiRepositoryImpl
import com.somethingsimple.feature_api_list.domain.ApisUseCase
import com.somethingsimple.feature_api_list.ui.ApisViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap


@Module
abstract class ApiListModule {


    @Binds
    @ApiListFeatureScope
    abstract fun bindApiRepository(apiRepositoryImpl: PublicApiRepositoryImpl): PublicApiRepository

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Module
    companion object {
        @Provides
        @ApiListFeatureScope
        @IntoMap
        @ViewModelKey(ApisViewModel::class)
        fun provideApiListViewModel(apisUseCase: ApisUseCase): ViewModel =
            ApisViewModel(apisUseCase)
    }

}