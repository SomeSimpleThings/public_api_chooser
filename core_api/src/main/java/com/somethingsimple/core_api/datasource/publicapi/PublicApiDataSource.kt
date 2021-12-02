package com.somethingsimple.core_api.datasource.publicapi

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single

interface PublicApiDataSource {
    fun getAllApis(): Single<List<ApiEntry>>
    fun getApiByCategory(categoryName: String): Single<List<ApiEntry>>
    fun getRandomApiByCategory(categoryName: String, count: Int): Single<List<ApiEntry>>
}