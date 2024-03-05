package com.example.gymbuddy.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.gymbuddy.data.entities.ArchivedTrainingModel
import com.example.gymbuddy.data.entities.TrainingPlanModel

@Dao
interface TrainingsDao {
    @Query("SELECT * FROM TrainingPlans")
    fun GetAllTrainingPlans() : List<TrainingPlanModel>

    @Query("SELECT * FROM ArchivedTrainings")
    fun GetAllTrainingsHistory() : List<ArchivedTrainingModel>
}