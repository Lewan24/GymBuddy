package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "TrainingPlans", indices=[Index(value=["TrainingName"], unique=true)])
data class TrainingPlanModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="Id") val id: Int = 0,
    @ColumnInfo(name = "TrainingName") var trainingName: String,
    @ColumnInfo(name = "Exercises") var exercises: String?
)
