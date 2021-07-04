package com.somethingsimple.publicapichooser.data.repository.category

import com.somethingsimple.publicapichooser.data.datasource.category.CategoryDataSource
import com.somethingsimple.publicapichooser.data.datasource.category.local.LocalCategoryDataSource
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CategoryRepositoryImpl(
    private val remoteDataSource: CategoryDataSource,
    private val localDataSource: LocalCategoryDataSource
) :
    CategoryRepository {

    override fun getCategories(): Single<List<Category>> =
        localDataSource
            .getCategories()
            .flatMap(::fetchRemoteIfRequired)
            .subscribeOn(Schedulers.io())


    private fun fetchRemoteIfRequired(categories: List<Category>): Single<List<Category>> =
        if (categories.isEmpty()) {
            remoteDataSource
                .getCategories()
                .flatMap(localDataSource::retain)
        } else {
            Single.just(categories)
        }
}