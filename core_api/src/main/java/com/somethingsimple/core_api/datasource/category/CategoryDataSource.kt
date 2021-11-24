package com.somethingsimple.core_api.datasource.category

import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface CategoryDataSource {
    fun getCategories(): Single<List<Category>>
}