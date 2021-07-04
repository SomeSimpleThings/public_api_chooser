package com.somethingsimple.publicapichooser.di.module.category

import com.somethingsimple.publicapichooser.ui.category.CategoriesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CategoryUiModule {

    @ContributesAndroidInjector
    abstract fun bindCategoriesFragment(): CategoriesFragment
}