package com.somethingsimple.feature_categories.data.repo

import android.util.Log
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.core_api.datasource.category.CategoryDataSource
import com.somethingsimple.core_api.datasource.category.local.LocalCategoryDataSource
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: CategoryDataSource,
    private val localDataSource: LocalCategoryDataSource
) :
    CategoryRepository {

    override fun getCategories(): Flowable<List<Category>> {
        Log.d("CategoryRepository", "getCategories")

        return localDataSource
            .getCategories()
            .flatMap(::getFromNetworkIfNeed)

    }

    private fun getFromNetworkIfNeed(categories: List<Category>): Flowable<List<Category>> {
        return if (categories.isEmpty()) {
            remoteDataSource
                .getCategories()
                .toFlowable()
                .flatMap(localDataSource::saveAndGet)
        } else
            Flowable.just(categories)
    }
}