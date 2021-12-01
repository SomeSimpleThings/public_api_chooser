package com.somethingsimple.feature_api_list.domain

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.feature_api_list.data.repo.PublicApiRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class ApisUseCase @Inject constructor(private val publicApiRepository: PublicApiRepository) {

    fun getApiForCategory(categoryName: String): Flowable<List<ApiEntry>> {
        return publicApiRepository.getPublicApiForCategory(categoryName)
    }

    fun getApiForCategory(category: Category): Flowable<List<ApiEntry>> {
        return publicApiRepository.getPublicApiForCategory(category.name)
    }
}