package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ArchivedTrainings")
data class ArchivedTrainingModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="Id") val id: Int = 0,
    @ColumnInfo(name="TrainingPlanJson") val trainingPlan: String, // TrainingPlanModel
    @ColumnInfo(name="TrainingTime") val trainingTime: String, // ex: 1h 25m
    @ColumnInfo(name="TotalWeightInKg") val totalWeightInKg: Int?
)