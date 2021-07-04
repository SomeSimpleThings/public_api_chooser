package com.somethingsimple.publicapichooser.data.vo


import com.google.gson.annotations.SerializedName

data class PublicApiEntries(
    @SerializedName("count") val count: Int,
    @SerializedName("entries") val entries: List<ApiEntry>
)