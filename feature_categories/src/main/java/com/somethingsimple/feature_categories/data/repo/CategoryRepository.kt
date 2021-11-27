package com.somethingsimple.feature_categories.data.repo

import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface CategoryRepository {
    fun getCategories(): Single<List<Category>>
}
