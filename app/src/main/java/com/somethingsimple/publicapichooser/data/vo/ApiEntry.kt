package com.somethingsimple.publicapichooser.data.vo


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ApiEntry(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo @SerializedName("API") val api: String,
    @ColumnInfo @SerializedName("Auth") val auth: String,
    @ColumnInfo @SerializedName("Category") val category: String,
    @ColumnInfo @SerializedName("Cors") val cors: String,
    @ColumnInfo @SerializedName("Description") val description: String,
    @ColumnInfo @SerializedName("HTTPS") val hTTPS: Boolean,
    @ColumnInfo @SerializedName("Link") val link: String
)