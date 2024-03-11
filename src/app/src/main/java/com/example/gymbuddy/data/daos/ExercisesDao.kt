package com.example.gymbuddy.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.gymbuddy.data.entities.ExerciseCategoryModel
import com.example.gymbuddy.data.entities.ExerciseModel

@Dao
interface ExercisesDao {
//    @Query("SELECT CategoryName FROM ExercisesCategories WHERE Id = :id LIMIT 1")
//    fun GetCategoryNameFromId(id: Int) : List<String>

    @Query("SELECT * FROM ExercisesCategories")
    fun GetAllExercisesCategories() : List<ExerciseCategoryModel>

    @Query("SELECT * FROM Exercises")
    fun GetAllExercises() : List<ExerciseModel>

    @Query("SELECT * FROM Exercises WHERE CategoryId = :id")
    fun GetAllMatchedCategoryExercise(id: Int) : List<ExerciseModel>
}