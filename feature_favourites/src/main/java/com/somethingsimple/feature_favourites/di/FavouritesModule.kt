package com.somethingsimple.feature_favourites.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.viewmodel.ViewModelFactory
import com.somethingsimple.core_api.viewmodel.ViewModelKey
import com.somethingsimple.feature_favourites.data.FavouritesRepository
import com.somethingsimple.feature_favourites.data.FavouritesRepositoryImpl
import com.somethingsimple.feature_favourites.ui.FavouritesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FavouritesModule {

    @Binds
    @FavouritesScope
    fun bindFavouritesRepository(favouritesRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository

    @Binds
    @FavouritesScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @FavouritesScope
    @IntoMap
    @ViewModelKey(FavouritesViewModel::class)
    fun provideCategoryViewModel(favouritesViewModel: FavouritesViewModel): ViewModel

}