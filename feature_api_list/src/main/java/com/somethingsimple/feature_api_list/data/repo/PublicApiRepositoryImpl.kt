package com.somethingsimple.feature_api_list.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class PublicApiRepositoryImpl @Inject constructor(
    private val remoteDataSource: PublicApiDataSource,
    private val localDataSource: LocalPublicApiDataSource
) : PublicApiRepository {
    override fun getPublicApiForCategory(categoryName: String): Maybe<List<ApiEntry>> =
        localDataSource
            .getApiByCategory(categoryName)
//            .flatMap { return@flatMap fetchRemoteIfRequired(it, categoryName) }


    override fun getPublicApiByLink(link: String): Maybe<ApiEntry> =
        localDataSource
            .getApiByLink(link)

//
//    private fun fetchRemoteIfRequired(
//        apis: List<ApiEntry>,
//        categoryName: String
//    ): Single<List<ApiEntry>> =
//        if (apis.isEmpty()) {
//            remoteDataSource
//                .getApiByCategory(categoryName)
//                .flatMap { return@flatMap localDataSource.retain(categoryName, it) }
//        } else {
//            Single.just(apis)
//        }
}