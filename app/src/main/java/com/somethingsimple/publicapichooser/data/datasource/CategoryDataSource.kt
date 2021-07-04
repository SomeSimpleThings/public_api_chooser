package com.somethingsimple.publicapichooser.data.datasource

import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single

interface CategoryDataSource {

    fun getCategories(): Single<List<Category>>
}