package com.somethingsimple.core_api.datasource.publicapi

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

interface LocalPublicApiDataSource {

    fun save(apiEntry: ApiEntry): Completable
    fun save(apis: List<ApiEntry>): Completable

    fun retain(apiEntry: ApiEntry): Maybe<ApiEntry>
    fun retain(apis: List<ApiEntry>): Maybe<List<ApiEntry>>
    fun retain(categoryName: String, apis: List<ApiEntry>): Maybe<List<ApiEntry>>

    //    fun getApiById(id: Long): Maybe<ApiEntry>
    fun getApiByLink(link: String): Maybe<ApiEntry>

    fun getCategories(): Maybe<List<Category>>
    fun getApiByCategory(categoryName: String): Maybe<List<ApiEntry>>
    fun getApiByCategory(categoryName: String, count: Int): Maybe<List<ApiEntry>>
}