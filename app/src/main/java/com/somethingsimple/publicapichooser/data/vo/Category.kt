package com.somethingsimple.publicapichooser.data.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val name: String
) {
    fun getNameWithId(): String = "$id $name"

}
