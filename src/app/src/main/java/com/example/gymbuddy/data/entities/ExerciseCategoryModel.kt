package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// TODO: Error throws that about this table does not exist even if it is xD
@Entity(tableName = "ExercisesCategories", indices=[Index(value=["CategoryName"], unique=true)])
data class ExerciseCategoryModel(
    @ColumnInfo(name = "Id") @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "CategoryName") val categoryName: String,
    @ColumnInfo(name = "ImageUrl") val imageUrl: String?
)