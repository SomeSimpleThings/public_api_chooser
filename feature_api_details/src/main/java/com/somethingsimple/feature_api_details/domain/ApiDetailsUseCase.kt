package com.somethingsimple.feature_api_details.domain

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.feature_api_details.data.ApiDetailsRepository
import javax.inject.Inject

class ApiDetailsUseCase @Inject constructor(private val repository: ApiDetailsRepository) {

    fun getApiForLink(link: String) = repository.getApiByLink(link)
    fun saveToFavourite(apiEntry: ApiEntry) =
        repository
            .saveOrDeleteFavourite(apiEntry)
            .andThen(getApiForLink(apiEntry.link))

}