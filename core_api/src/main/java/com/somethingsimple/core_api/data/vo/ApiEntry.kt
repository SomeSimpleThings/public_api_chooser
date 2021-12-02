package com.somethingsimple.core_api.data.vo

import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.network.dto.ApiEntryDto

data class ApiEntry(
    val api: String,
    val auth: String,
    val category: String,
    val cors: String,
    val description: String,
    val isHttps: Boolean,
    val link: String
) {
    constructor(apiEntryDto: ApiEntryDto) : this(
        apiEntryDto.api,
        apiEntryDto.auth,
        apiEntryDto.category,
        apiEntryDto.cors,
        apiEntryDto.description,
        apiEntryDto.hTTPS,
        apiEntryDto.link
    )

    constructor(apiEntryEntity: ApiEntryEntity) : this(
        apiEntryEntity.api,
        apiEntryEntity.auth,
        apiEntryEntity.category,
        apiEntryEntity.cors,
        apiEntryEntity.description,
        apiEntryEntity.hTTPS,
        apiEntryEntity.link
    )
}
