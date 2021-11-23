package com.somethingsimple.publicapichooser.di.module.category

import com.somethingsimple.publicapichooser.ui.category.CategoriesFragment
import dagger.Module

@Module
abstract class CategoryUiModule {

    abstract fun bindCategoriesFragment(): CategoriesFragment
}