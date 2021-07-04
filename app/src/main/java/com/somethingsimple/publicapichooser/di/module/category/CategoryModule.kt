package com.somethingsimple.publicapichooser.di.module.category

import com.somethingsimple.publicapichooser.data.api.PublicApisApi
import com.somethingsimple.publicapichooser.data.datasource.CategoryDataSource
import com.somethingsimple.publicapichooser.data.datasource.local.LocalCategoryDataSource
import com.somethingsimple.publicapichooser.data.datasource.local.LocalCategoryDataSourceImpl
import com.somethingsimple.publicapichooser.data.datasource.remote.RemoteCategoryDataSource
import com.somethingsimple.publicapichooser.data.db.ApiChooserDb
import com.somethingsimple.publicapichooser.data.repository.category.CategoryRepository
import com.somethingsimple.publicapichooser.data.repository.category.CategoryRepositoryImpl
import com.somethingsimple.publicapichooser.di.module.DbModule
import com.somethingsimple.publicapichooser.di.module.NetworkModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CategoryUiModule::class, NetworkModule::class, DbModule::class])
class CategoryModule {

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
        db: ApiChooserDb
    ): LocalCategoryDataSource =
        LocalCategoryDataSourceImpl(db)
}