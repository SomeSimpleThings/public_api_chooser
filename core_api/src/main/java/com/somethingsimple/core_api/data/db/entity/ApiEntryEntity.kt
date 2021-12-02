package com.somethingsimple.core_api.data.db.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ApiEntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val api: String,
    @ColumnInfo val auth: String,
    @ColumnInfo val category: String,
    @ColumnInfo val cors: String,
    @ColumnInfo val description: String,
    @ColumnInfo val hTTPS: Boolean,
    @ColumnInfo val link: String,
) {
}