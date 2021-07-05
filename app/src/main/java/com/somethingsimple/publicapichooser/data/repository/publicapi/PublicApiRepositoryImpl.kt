package com.somethingsimple.publicapichooser.data.repository.publicapi

import com.somethingsimple.publicapichooser.data.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.publicapichooser.data.datasource.publicapi.local.LocalPublicApiDataSource
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class PublicApiRepositoryImpl(
    private val remoteDataSource: PublicApiDataSource,
    private val localDataSource: LocalPublicApiDataSource
) : PublicApiRepository {
    override fun getPublicApiForCategory(categoryName: String): Single<List<ApiEntry>> =
        localDataSource
            .getApiByCategory(categoryName)
            .flatMap { return@flatMap fetchRemoteIfRequired(it, categoryName) }
            .subscribeOn(Schedulers.io())


    override fun getPublicApiById(id: Long): Single<ApiEntry> =
        localDataSource
            .getApiById(id)
            .subscribeOn(Schedulers.io())


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