package com.somethingsimple.feature_categories.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.viewmodel.ViewModelFactory
import com.somethingsimple.core_api.viewmodel.ViewModelKey
import com.somethingsimple.feature_categories.data.repo.PublicApiRepository
import com.somethingsimple.feature_categories.data.repo.PublicApiRepositoryImpl
import com.somethingsimple.feature_categories.ui.category.CategoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CategoryModule {

    @Binds
    @CategoryFeatureScope
    fun bindApiEntryRepository(publicApiRepositoryImpl: PublicApiRepositoryImpl): PublicApiRepository

    @Binds
    @CategoryFeatureScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @CategoryFeatureScope
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    fun provideCategoryViewModel(categoryViewModel: CategoryViewModel): ViewModel

}