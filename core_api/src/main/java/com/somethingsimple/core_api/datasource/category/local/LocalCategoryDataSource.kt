package com.somethingsimple.core_api.datasource.category.local

import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface LocalCategoryDataSource {
    fun getCategory(name: String): Single<Category>
    fun retain(categories: List<Category>): Single<List<Category>>
    fun retain(category: Category): Single<Category>
    fun getCategories(): Single<List<Category>>

}