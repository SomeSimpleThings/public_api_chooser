package com.somethingsimple.core_api.data.db.entity

data class ApiEntrySynt(
    val api: String,
    val auth: String,
    val category: String,
    val cors: String,
    val description: String,
    val hTTPS: Boolean,
    val link: String,
    val favourite: Boolean
)
