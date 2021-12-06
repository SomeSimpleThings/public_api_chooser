package com.somethingsimple.feature_api_list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.viewmodel.ViewModelFactory
import com.somethingsimple.core_api.viewmodel.ViewModelKey
import com.somethingsimple.feature_api_list.data.repo.PublicApiRepository
import com.somethingsimple.feature_api_list.data.repo.PublicApiRepositoryImpl
import com.somethingsimple.feature_api_list.ui.ApisViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ApiListModule {


    @Binds
    @ApiListFeatureScope
    fun bindApiRepository(apiRepositoryImpl: PublicApiRepositoryImpl): PublicApiRepository

    @Binds
    @ApiListFeatureScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(ApisViewModel::class)
    fun bindApiListViewModel(apisViewModel: ApisViewModel): ViewModel

}