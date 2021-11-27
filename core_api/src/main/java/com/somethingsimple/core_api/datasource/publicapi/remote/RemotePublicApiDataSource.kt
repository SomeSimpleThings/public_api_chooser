package com.somethingsimple.core_api.datasource.publicapi.remote

import com.somethingsimple.core_api.data.network.PublicApi
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import io.reactivex.rxjava3.core.Single
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

}