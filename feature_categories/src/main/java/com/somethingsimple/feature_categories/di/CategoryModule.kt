package com.somethingsimple.feature_categories.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.somethingsimple.core_api.viewmodel.ViewModelFactory
import com.somethingsimple.core_api.viewmodel.ViewModelKey
import com.somethingsimple.feature_categories.data.repo.CategoryRepository
import com.somethingsimple.feature_categories.data.repo.CategoryRepositoryImpl
import com.somethingsimple.feature_categories.data.repo.PublicApiRepository
import com.somethingsimple.feature_categories.data.repo.PublicApiRepositoryImpl
import com.somethingsimple.feature_categories.domain.CategoryUseCase
import com.somethingsimple.feature_categories.ui.category.CategoryViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class CategoryModule {

    @Binds
    @CategoryFeatureScope
    abstract fun bindCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    @CategoryFeatureScope
    abstract fun bindApiEntryRepository(publicApiRepositoryImpl: PublicApiRepositoryImpl): PublicApiRepository

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Module
    companion object {
        @Provides
        @CategoryFeatureScope
        @IntoMap
        @ViewModelKey(CategoryViewModel::class)
        fun provideCategoryViewModel(categoryUseCase: CategoryUseCase): ViewModel =
            CategoryViewModel(categoryUseCase)
    }


}