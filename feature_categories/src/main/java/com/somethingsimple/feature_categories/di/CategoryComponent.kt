package com.somethingsimple.feature_categories.di

import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.feature_categories.ui.category.CategoriesFragment
import dagger.Component

@CategoryFeatureScope
@Component(
    dependencies = [CoreProvider::class],
    modules = [CategoryModule::class]
)
interface CategoryComponent {

    companion object {
        fun create(coreProvider: CoreProvider): CategoryComponent {
            return DaggerCategoryComponent
                .builder()
                .coreProvider(coreProvider)
                .build()
        }
    }

    fun inject(categoriesFragment: CategoriesFragment)
}