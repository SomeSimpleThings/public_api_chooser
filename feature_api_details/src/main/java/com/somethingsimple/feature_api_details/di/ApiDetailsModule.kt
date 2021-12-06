package com.somethingsimple.feature_api_details.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.viewmodel.ViewModelFactory
import com.somethingsimple.core_api.viewmodel.ViewModelKey
import com.somethingsimple.feature_api_details.data.ApiDetailsRepository
import com.somethingsimple.feature_api_details.data.ApiDetailsRepositoryImpl
import com.somethingsimple.feature_api_details.ui.ApiDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ApiDetailsModule {

    @Binds
    @ApiDetailsScope
    fun bindApiRepository(apiRepositoryImpl: ApiDetailsRepositoryImpl): ApiDetailsRepository

    @Binds
    @ApiDetailsScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @ApiDetailsScope
    @IntoMap
    @ViewModelKey(ApiDetailsViewModel::class)
    fun bindApiListViewModel(apiDetailsViewModel: ApiDetailsViewModel): ViewModel

}
