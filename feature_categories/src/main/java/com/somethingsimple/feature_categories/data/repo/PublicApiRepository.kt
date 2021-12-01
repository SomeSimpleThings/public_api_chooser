package com.somethingsimple.feature_categories.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface PublicApiRepository {
    fun getPublicApis(): Maybe<List<ApiEntry>>
    fun getCategories(): Maybe<List<Category>>
    fun getPublicApiForCategory(categoryName: String, count: Int = 3): Maybe<List<ApiEntry>>
    fun getRandomApiForCategory(categoryName: String, count: Int = 3): Single<List<ApiEntry>>
}