package com.somethingsimple.publicapichooser.data.repository.category

import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface CategoryRepository {
    fun getCategories(): Single<List<Category>>
}
