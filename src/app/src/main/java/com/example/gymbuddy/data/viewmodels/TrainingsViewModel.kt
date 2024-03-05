package com.example.gymbuddy.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.gymbuddy.data.daos.TrainingsDao
import com.example.gymbuddy.data.databases.AppDatabase
import com.example.gymbuddy.data.entities.TrainingPlanModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrainingsViewModel(app: Application) : AndroidViewModel(app) {
    private val db: TrainingsDao
    private var allTrainingPlans: MutableLiveData<List<TrainingPlanModel>>

    init {
        db = AppDatabase.getInstance(app).TrainingsDao()
        allTrainingPlans = MutableLiveData()
    }

    fun getAllTrainingPlansAsObservers() : MutableLiveData<List<TrainingPlanModel>>{
        reloadTrainingPlans()

        return allTrainingPlans
    }

    fun reloadTrainingPlans() = viewModelScope.launch(Dispatchers.IO){
        allTrainingPlans.postValue(db.GetAllTrainingPlans())
    }
}