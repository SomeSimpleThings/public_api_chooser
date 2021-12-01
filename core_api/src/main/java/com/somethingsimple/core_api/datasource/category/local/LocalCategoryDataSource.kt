package com.somethingsimple.core_api.datasource.category.local

import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface LocalCategoryDataSource {
    fun getCategory(name: String): Single<Category>
    fun save(categories: List<Category>): Completable
    fun save(category: Category): Completable
    fun saveAndGet(categories: List<Category>): Flowable<List<Category>>
    fun saveAndGetCategory(category: Category): Single<Category>
    fun getCategories(): Flowable<List<Category>>

}