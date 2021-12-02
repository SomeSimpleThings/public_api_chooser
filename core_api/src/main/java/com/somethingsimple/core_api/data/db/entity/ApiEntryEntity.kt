package com.somethingsimple.core_api.data.db.entity


import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("category")])
data class ApiEntryEntity(
    val api: String,
    val auth: String,
    val category: String,
    val cors: String,
    val description: String,
    val hTTPS: Boolean,
    @PrimaryKey
    val link: String
) {
    var favourite: Boolean = false
}