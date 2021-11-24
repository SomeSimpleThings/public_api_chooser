package com.somethingsimple.core_api.datasource.category.local

import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.core_api.datasource.category.CategoryDataSource
import io.reactivex.rxjava3.core.Single

interface LocalCategoryDataSource : CategoryDataSource {
    fun getCategory(name: String): Single<Category>
    fun retain(categories: List<Category>): Single<List<Category>>
    fun retain(category: Category): Single<Category>
}