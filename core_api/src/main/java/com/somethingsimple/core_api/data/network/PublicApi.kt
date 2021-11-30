package com.somethingsimple.core_api.data.network

import com.somethingsimple.core_api.data.network.dto.PublicApiEntries
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicApi {
    @GET("/categories")
    fun getCategories(): Single<List<String>>

    @GET("/entries")
    fun getApisForCategory(@Query("category") category: String): Single<PublicApiEntries>

    @GET("/random")
    fun getRandomApiForCategory(@Query("category") category: String): Observable<PublicApiEntries>
}