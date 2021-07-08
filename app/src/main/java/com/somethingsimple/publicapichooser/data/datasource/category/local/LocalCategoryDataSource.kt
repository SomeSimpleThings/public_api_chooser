package com.somethingsimple.publicapichooser.data.datasource.category.local

import com.somethingsimple.publicapichooser.data.datasource.category.CategoryDataSource
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface LocalCategoryDataSource : CategoryDataSource {
    fun retain(categories: List<Category>): Single<List<Category>>
    fun retain(category: Category): Single<Category>
}