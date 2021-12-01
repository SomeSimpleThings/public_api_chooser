package com.somethingsimple.core_api.datasource.publicapi.local

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

interface LocalPublicApiDataSource {
    fun save(apis: List<ApiEntry>): Completable
    fun retain(apis: List<ApiEntry>): Maybe<List<ApiEntry>>
    fun retain(categoryName: String, apis: List<ApiEntry>): Maybe<List<ApiEntry>>
    fun retain(apiEntry: ApiEntry): Maybe<ApiEntry>
    fun getApiById(id: Long): Maybe<ApiEntry>
    fun getApiByName(name: String): Maybe<ApiEntry>
    fun getCategories(): Maybe<List<Category>>
    fun getApiByCategory(categoryName: String): Maybe<List<ApiEntry>>
    fun getApiByCategory(categoryName: String, count: Int = 3): Maybe<List<ApiEntry>>
}