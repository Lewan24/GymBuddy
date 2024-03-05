package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exercises")
data class ExerciseModel(
    @PrimaryKey @ColumnInfo(name="Id") val id: Int = 0
)
