package com.somethingsimple.feature_categories.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PublicApiRepositoryImpl @Inject constructor(
    private val remoteDataSource: PublicApiDataSource,
    private val localDataSource: LocalPublicApiDataSource
) : PublicApiRepository {
    override fun getPublicApiForCategory(categoryName: String): Single<List<ApiEntry>> =
        localDataSource
            .getApiByCategory(categoryName)
            .flatMap { return@flatMap fetchRemoteIfRequired(it, categoryName) }

    override fun getRandomApiForCategory(categoryName: String, count: Int): Single<List<ApiEntry>> {
        return remoteDataSource.getRandomApiByCategory(categoryName)
    }

    private fun fetchRemoteIfRequired(
        apis: List<ApiEntry>,
        categoryName: String
    ): Single<List<ApiEntry>> =
        if (apis.isEmpty()) {
            remoteDataSource
                .getApiByCategory(categoryName)
                .flatMap { return@flatMap localDataSource.retain(categoryName, it) }
        } else {
            Single.just(apis)
        }
}