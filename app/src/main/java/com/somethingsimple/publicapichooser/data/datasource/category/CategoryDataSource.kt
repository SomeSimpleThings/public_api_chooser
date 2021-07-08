package com.somethingsimple.publicapichooser.data.datasource.category

import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface CategoryDataSource {

    fun getCategories(): Single<List<Category>>
}