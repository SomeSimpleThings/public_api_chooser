package com.somethingsimple.core_api.network.dto


import com.google.gson.annotations.SerializedName
import com.somethingsimple.core_api.network.dto.ApiEntry

data class PublicApiEntries(
    @SerializedName("count") val count: Int,
    @SerializedName("entries") val entries: List<ApiEntry>
)
