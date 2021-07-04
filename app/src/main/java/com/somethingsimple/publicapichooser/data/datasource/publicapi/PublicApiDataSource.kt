package com.somethingsimple.publicapichooser.data.datasource.publicapi

import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single

interface PublicApiDataSource {
    fun getApiByCategory(categoryName: String): Single<List<ApiEntry>>
}