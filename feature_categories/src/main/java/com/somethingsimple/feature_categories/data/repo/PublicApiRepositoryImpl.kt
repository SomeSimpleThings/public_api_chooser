package com.somethingsimple.feature_categories.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSource
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PublicApiRepositoryImpl @Inject constructor(
    private val remoteDataSource: PublicApiDataSource,
    private val localDataSource: LocalPublicApiDataSource
) : PublicApiRepository {
    override fun getPublicApis(): Maybe<List<ApiEntry>> {
        return remoteDataSource
            .getAllApis()
            .toMaybe()
            .flatMap { localDataSource.retain(it) }
    }

    override fun getCategories(): Maybe<List<Category>> {
        return localDataSource
            .getCategories()
            .flatMap(::fetchRemoteIfRequired)
    }

    override fun getPublicApiForCategory(
        categoryName: String,
        count: Int
    ): Maybe<List<ApiEntry>> =
        localDataSource
            .getApiByCategory(categoryName, count)
            .flatMap { return@flatMap fetchRemoteIfRequired(it, categoryName) }

    override fun getRandomApiForCategory(categoryName: String, count: Int): Single<List<ApiEntry>> {
        return remoteDataSource.getRandomApiByCategory(categoryName, count)
    }

    private fun fetchRemoteIfRequired(
        categories: List<Category>,
    ): Maybe<List<Category>> =
        if (categories.isEmpty()) {
            remoteDataSource
                .getAllApis()
                .toMaybe()
                .flatMap {
                    localDataSource
                        .save(it)
                        .andThen(
                            localDataSource
                                .getCategories()
                        )
                }
        } else {
            Maybe.just(categories)
        }

    private fun fetchRemoteIfRequired(
        apis: List<ApiEntry>,
        categoryName: String
    ): Maybe<List<ApiEntry>> =
        if (apis.isEmpty()) {
            remoteDataSource
                .getApiByCategory(categoryName)
                .toMaybe()
                .flatMap { localDataSource.retain(categoryName, it) }
        } else {
            Maybe.just(apis)
        }
}