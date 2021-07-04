package com.somethingsimple.publicapichooser.data.datasource.local

import com.somethingsimple.publicapichooser.data.datasource.CategoryDataSource
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface LocalCategoryDataSource : CategoryDataSource {
    fun retain(categories: List<Category>): Single<List<Category>>
    fun retain(category: Category): Single<Category>
}