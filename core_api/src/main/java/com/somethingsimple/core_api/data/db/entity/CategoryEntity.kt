package com.somethingsimple.core_api.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val name: String
) {
    fun getNameWithId(): String = "$id $name"

}
