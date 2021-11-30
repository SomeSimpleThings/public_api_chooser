package com.somethingsimple.core_api.datasource.publicapi.remote

import com.somethingsimple.core_api.data.network.PublicApi
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RemotePublicApiDataSource @Inject constructor(private val api: PublicApi) :
    PublicApiDataSource {
    override fun getApiByCategory(categoryName: String): Single<List<ApiEntry>> =
        api.getApisForCategory(categoryName)
            .flatMap {
                return@flatMap Single
                    .just(it.entryDtos.map { apiEntryDto ->
                        ApiEntry(apiEntryDto)
                    })
            }

    override fun getRandomApiByCategory(
        categoryName: String,
        count: Int
    ): Single<List<ApiEntry>> {
        return Observable.range(0, count).flatMap {
            api.getRandomApiForCategory(categoryName)
//                .delay(2, TimeUnit.SECONDS)
                .map { entries -> ApiEntry(entries.entryDtos.first()) }
        }.toList()
    }
}