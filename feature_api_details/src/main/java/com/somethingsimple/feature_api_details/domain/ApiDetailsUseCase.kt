package com.somethingsimple.feature_api_details.domain

import com.somethingsimple.feature_api_details.data.ApiDetailsRepository
import javax.inject.Inject

class ApiDetailsUseCase @Inject constructor(private val repository: ApiDetailsRepository) {

    fun getApiForLink(link: String) = repository.getApiByLink(link)
}