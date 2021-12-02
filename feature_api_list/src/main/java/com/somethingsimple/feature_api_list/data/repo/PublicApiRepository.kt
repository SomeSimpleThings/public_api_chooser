package com.somethingsimple.feature_api_list.data.repo

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Maybe

interface PublicApiRepository {
    fun getPublicApiForCategory(categoryName: String): Maybe<List<ApiEntry>>
    fun getPublicApiByLink(link: String): Maybe<ApiEntry>
}