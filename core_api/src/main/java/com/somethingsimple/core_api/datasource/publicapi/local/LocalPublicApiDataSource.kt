package com.somethingsimple.core_api.datasource.publicapi.local

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import io.reactivex.rxjava3.core.Single

interface LocalPublicApiDataSource : PublicApiDataSource {
    fun retain(categoryName: String, apis: List<ApiEntry>): Single<List<ApiEntry>>
    fun retain(apiEntry: ApiEntry): Single<ApiEntry>
    fun getApiById(id: Long): Single<ApiEntry>
}