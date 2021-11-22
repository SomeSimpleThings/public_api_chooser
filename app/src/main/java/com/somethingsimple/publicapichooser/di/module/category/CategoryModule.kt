package com.somethingsimple.publicapichooser.di.module.category

import com.somethingsimple.publicapichooser.data.api.PublicApisApi
import com.somethingsimple.publicapichooser.data.datasource.category.CategoryDataSource
import com.somethingsimple.publicapichooser.data.datasource.category.local.LocalCategoryDataSource
import com.somethingsimple.publicapichooser.data.datasource.category.local.LocalCategoryDataSourceImpl
import com.somethingsimple.publicapichooser.data.datasource.category.remote.RemoteCategoryDataSource
import com.somethingsimple.publicapichooser.data.db.ApiChooserDb
import com.somethingsimple.publicapichooser.data.db.CategoryDao
import com.somethingsimple.publicapichooser.data.repository.category.CategoryRepository
import com.somethingsimple.publicapichooser.data.repository.category.CategoryRepositoryImpl
import com.somethingsimple.publicapichooser.data.vo.Category
import com.somethingsimple.publicapichooser.di.module.DbModule
import com.somethingsimple.publicapichooser.di.module.NetworkModule
import com.somethingsimple.publicapichooser.ui.category.CategoryItemView
import com.somethingsimple.publicapichooser.ui.category.CategoryListPresenter
import com.somethingsimple.publicapichooser.ui.common.ListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CategoryUiModule::class, NetworkModule::class, DbModule::class])
class CategoryModule {

    @Singleton
    @Provides
    fun provideCategoryListPresenter(): ListPresenter<CategoryItemView, Category> =
        CategoryListPresenter()

    @Singleton
    @Provides
    fun provideCategoryRepository(
        remoteCategoryDataSource: CategoryDataSource,
        localCategoryDataSource: LocalCategoryDataSource
    ): CategoryRepository =
        CategoryRepositoryImpl(
            remoteCategoryDataSource,
            localCategoryDataSource
        )

    @Singleton
    @Provides
    fun provideRemoteCategoryDataSource(
        publicApisApi: PublicApisApi
    ): CategoryDataSource =
        RemoteCategoryDataSource(publicApisApi)

    @Singleton
    @Provides
    fun provideLocalCategoryDataSource(
        dao: CategoryDao
    ): LocalCategoryDataSource =
        LocalCategoryDataSourceImpl(dao)
}