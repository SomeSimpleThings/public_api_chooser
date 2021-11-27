package com.somethingsimple.core_api.data.network.dto


import com.google.gson.annotations.SerializedName

data class PublicApiEntries(
    @SerializedName("count") val count: Int,
    @SerializedName("entries") val entryDtos: List<ApiEntryDto>
)
