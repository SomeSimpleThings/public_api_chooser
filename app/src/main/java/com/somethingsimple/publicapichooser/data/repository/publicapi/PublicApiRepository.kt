package com.somethingsimple.publicapichooser.data.repository.publicapi

import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single

interface PublicApiRepository {
    fun getPublicApiForCategory(categoryName: String): Single<List<ApiEntry>>
    fun getPublicApiById(id: Long): Single<ApiEntry>
}