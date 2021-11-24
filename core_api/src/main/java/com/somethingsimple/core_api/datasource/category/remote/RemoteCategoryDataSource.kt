package com.somethingsimple.core_api.datasource.category.remote

import com.somethingsimple.core_api.data.network.PublicApi
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.core_api.datasource.category.CategoryDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteCategoryDataSource @Inject constructor(private val api: PublicApi) :
    CategoryDataSource {
    override fun getCategories(): Single<List<Category>> =
        api.getCategories().flatMap { namesList ->
            val categories: MutableList<Category> = mutableListOf()
            namesList.forEach { categories.add(Category(it)) }
            return@flatMap Single.just(categories)
        }
}