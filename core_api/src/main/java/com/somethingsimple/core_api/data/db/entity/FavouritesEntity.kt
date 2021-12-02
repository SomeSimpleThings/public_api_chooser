package com.somethingsimple.core_api.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index("apiLink")],
    foreignKeys = [ForeignKey(
        entity = ApiEntryEntity::class,
        parentColumns = ["link"],
        childColumns = ["apiLink"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class FavouritesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val apiLink: String
)
