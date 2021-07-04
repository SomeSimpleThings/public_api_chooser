package com.somethingsimple.publicapichooser.data.datasource.remote

import com.somethingsimple.publicapichooser.data.api.PublicApisApi
import com.somethingsimple.publicapichooser.data.datasource.CategoryDataSource
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single

class RemoteCategoryDataSource(private val api: PublicApisApi) : CategoryDataSource {
    override fun getCategories(): Single<List<Category>> =
        api.getCategories().flatMap { namesList ->
            val categories: MutableList<Category> = mutableListOf()
            namesList.forEach { categories.add(Category(0, it)) }
            return@flatMap Single.just(categories)
        }
}