package com.somethingsimple.feature_api_details.data

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

interface ApiDetailsRepository {
    fun getApiForName(name: String): Maybe<ApiEntry>

    //    fun getApiById(id: Long): Maybe<ApiEntry>
    fun getApiByLink(link: String): Maybe<ApiEntry>
    fun saveOrDeleteFavourite(apiEntry: ApiEntry): Completable
}