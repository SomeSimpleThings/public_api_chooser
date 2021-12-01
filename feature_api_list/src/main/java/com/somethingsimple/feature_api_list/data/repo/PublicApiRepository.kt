package com.somethingsimple.feature_api_list.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface PublicApiRepository {
    fun getPublicApiForCategory(categoryName: String): Flowable<List<ApiEntry>>
    fun getPublicApiById(id: Long): Single<ApiEntry>
}