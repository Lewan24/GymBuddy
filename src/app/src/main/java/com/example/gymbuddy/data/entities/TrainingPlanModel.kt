package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TrainingPlans")
data class TrainingPlanModel(
    @PrimaryKey @ColumnInfo(name="Id") val id: Int = 0,
    @ColumnInfo(name = "TrainingName") var trainingName: String,
    @ColumnInfo(name = "Exercises") var exercises: String
)
