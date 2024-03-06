package com.example.gymbuddy.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.gymbuddy.data.daos.ExercisesDao
import com.example.gymbuddy.data.databases.AppDatabase
import com.example.gymbuddy.data.entities.ExerciseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExercisesDbViewModel(app: Application) : AndroidViewModel(app) {
    private val db: ExercisesDao
    private var allExercises: MutableLiveData<List<ExerciseModel>>

    init {
        db = AppDatabase.getInstance(app).ExercisesDao()
        allExercises = MutableLiveData()
    }

    fun getAllExercisesAsObservers() : MutableLiveData<List<ExerciseModel>> {
        reloadExercises()

        return allExercises
    }

    private fun reloadExercises() = viewModelScope.launch(Dispatchers.IO){
        allExercises.postValue(db.GetAllExercises())
    }
}