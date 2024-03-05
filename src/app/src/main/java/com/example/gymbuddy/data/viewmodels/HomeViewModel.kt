package com.example.gymbuddy.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gymbuddy.data.daos.TrainingsDao
import com.example.gymbuddy.data.databases.AppDatabase

class HomeViewModel(app: Application) : AndroidViewModel(app){
    private val db: TrainingsDao

    init {
        db = AppDatabase.getInstance(app).TrainingsDao()
    }
}