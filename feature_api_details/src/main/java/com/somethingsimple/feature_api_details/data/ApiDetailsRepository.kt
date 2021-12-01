package com.somethingsimple.feature_api_details.data

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface ApiDetailsRepository {
    fun getApiForName(name: String): Maybe<ApiEntry>
    fun getApiById(id: Long): Maybe<ApiEntry>
}