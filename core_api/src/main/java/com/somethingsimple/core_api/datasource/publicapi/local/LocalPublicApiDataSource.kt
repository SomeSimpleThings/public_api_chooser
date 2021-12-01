package com.somethingsimple.core_api.datasource.publicapi.local

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface LocalPublicApiDataSource {
    fun retain(categoryName: String, apis: List<ApiEntry>): Flowable<List<ApiEntry>>
    fun retain(apiEntry: ApiEntry): Single<ApiEntry>
    fun getApiById(id: Long): Single<ApiEntry>
    fun getApiByName(name: String): Single<ApiEntry>
    fun getApiByCategory(categoryName: String): Flowable<List<ApiEntry>>
    fun getApiByCategory(categoryName: String, count: Int = 3): Flowable<List<ApiEntry>>
}