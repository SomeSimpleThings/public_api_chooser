package com.somethingsimple.core_api.network

import com.somethingsimple.core_api.network.dto.PublicApiEntries
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicApi {
    @GET("/categories")
    fun getCategories(): Single<List<String>>

    @GET("/entries")
    fun getApisForCategory(@Query("category") category: String): Single<PublicApiEntries>
}