package com.somethingsimple.feature_categories.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single

interface PublicApiRepository {
    fun getPublicApiForCategory(categoryName: String, count: Int = 3): Single<List<ApiEntry>>
    fun getRandomApiForCategory(categoryName: String, count: Int = 3): Single<List<ApiEntry>>
}