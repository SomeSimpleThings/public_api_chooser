package com.somethingsimple.publicapichooser.data.datasource.publicapi.local

import com.somethingsimple.publicapichooser.data.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single

interface LocalPublicApiDataSource : PublicApiDataSource {
    fun retain(categoryName: String, apis: List<ApiEntry>): Single<List<ApiEntry>>
    fun retain(apiEntry: ApiEntry): Single<ApiEntry>
}