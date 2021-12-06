package com.somethingsimple.feature_categories.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.core_api.datasource.AppPrefsDataSource
import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PublicApiRepositoryImpl @Inject constructor(
    private val remoteDataSource: PublicApiDataSource,
    private val localDataSource: LocalPublicApiDataSource,
    private val appPrefsDataSource: AppPrefsDataSource
) : PublicApiRepository {

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
        if (categories.isEmpty() || isOutdated()) {
            appPrefsDataSource.saveLastUpdateTime(Calendar.getInstance().time)
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

    private fun isOutdated(): Boolean {
        val delta = Calendar.getInstance().time.time - appPrefsDataSource.getLastUpdateTime().time

        return TimeUnit.HOURS.convert(delta, TimeUnit.MILLISECONDS) > 1
    }
}