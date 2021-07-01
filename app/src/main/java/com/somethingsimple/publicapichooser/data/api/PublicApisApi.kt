package com.somethingsimple.publicapichooser.data.api

import com.somethingsimple.publicapichooser.data.vo.Category
import com.somethingsimple.publicapichooser.data.vo.PublicApiEntries
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicApisApi {
    @GET("/categories")
    fun getCategories(): Single<List<Category>>

    @GET("/entries")
    fun getApisForCategory(@Query("category") category: String): Single<PublicApiEntries>
}