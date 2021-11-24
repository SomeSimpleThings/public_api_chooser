package com.somethingsimple.publicapichooser.di.component

import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.publicapichooser.di.module.category.CategoryModule
import com.somethingsimple.publicapichooser.ui.category.CategoriesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreProvider::class, AppProvider::class],
    modules = [CategoryModule::class]
)
interface CategoryComponent {

    companion object {
        private var mainComponent: CategoryComponent? = null

        fun create(coreProvider: CoreProvider,appProvider: AppProvider): CategoryComponent {
            return mainComponent ?: DaggerCategoryComponent
                .builder()
                .coreProvider(coreProvider)
                .appProvider(appProvider)
                .build().also {
                    mainComponent = it
                }
        }
    }

    fun inject(fragment: CategoriesFragment)
}
