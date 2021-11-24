package com.somethingsimple.core_api.data.network.dto


import com.google.gson.annotations.SerializedName

data class ApiEntryDto(
    @SerializedName("API") val api: String,
    @SerializedName("Auth") val auth: String,
    @SerializedName("Category") val category: String,
    @SerializedName("Cors") val cors: String,
    @SerializedName("Description") val description: String,
    @SerializedName("HTTPS") val hTTPS: Boolean,
    @SerializedName("Link") val link: String

) {
    fun isHttpsCorrect(): Boolean {
        return if (hTTPS)
            link.startsWith("https:")
        else
            link.startsWith("http:")
    }
}