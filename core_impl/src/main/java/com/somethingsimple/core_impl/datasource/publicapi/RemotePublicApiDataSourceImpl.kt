package com.somethingsimple.core_impl.datasource.publicapi

import com.somethingsimple.core_api.data.network.PublicApi
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemotePublicApiDataSourceImpl @Inject constructor(private val api: PublicApi) :
    PublicApiDataSource {

    override fun getAllApis(): Single<List<ApiEntry>> {
        return api.getAllApis().flatMap { publicApiEntries ->
            Single.just(publicApiEntries.entryDtos.map { ApiEntry(it) })
        }
    }

    override fun getApiByCategory(categoryName: String): Single<List<ApiEntry>> =
        api.getApisForCategory(categoryName)
            .flatMap {
                Single.just(it.entryDtos.map { apiEntryDto ->
                    ApiEntry(apiEntryDto)
                })
            }

    override fun getRandomApiByCategory(
        categoryName: String,
        count: Int
    ): Single<List<ApiEntry>> {
        return Observable.range(0, count).flatMap {
            api.getRandomApiForCategory(categoryName)
                .map { entries -> ApiEntry(entries.entryDtos.first()) }
        }.toList()
    }
}