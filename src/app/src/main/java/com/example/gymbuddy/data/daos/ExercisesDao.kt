package com.example.gymbuddy.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.gymbuddy.data.entities.ExerciseModel

@Dao
interface ExercisesDao {
    @Query("SELECT * FROM Exercises")
    fun GetAllExercises() : List<ExerciseModel>
}