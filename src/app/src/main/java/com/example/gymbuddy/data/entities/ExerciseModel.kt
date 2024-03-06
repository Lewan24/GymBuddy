package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exercises")
data class ExerciseModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="Id") val id: Int = 0,
    @ColumnInfo(name="ExerciseName") val exerciseName: String,
    @ColumnInfo(name="MusclesUsedJson") val musclesUsed: String, //List<String>
    @ColumnInfo(name="LevelJson") val level: String, // Level as string
    @ColumnInfo(name="Advices") val advices: String,
    @ColumnInfo(name="VideoUrl") val videoUrl: String
)

enum class Level{
    Beginner,
    Intermediate,
    Expert,
    Any
}