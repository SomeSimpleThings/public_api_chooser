package com.somethingsimple.publicapichooser.data.datasource.publicapi.remote

import com.somethingsimple.publicapichooser.data.api.PublicApisApi
import com.somethingsimple.publicapichooser.data.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single

class RemotePublicApiDataSource(private val api: PublicApisApi) : PublicApiDataSource {
    override fun getApiByCategory(categoryName: String): Single<List<ApiEntry>> =
        api.getApisForCategory(categoryName)
            .flatMap { return@flatMap Single.just(it.entries) }

}