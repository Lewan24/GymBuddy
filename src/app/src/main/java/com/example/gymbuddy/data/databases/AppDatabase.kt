package com.example.gymbuddy.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gymbuddy.data.daos.ExercisesDao
import com.example.gymbuddy.data.daos.TrainingsDao
import com.example.gymbuddy.data.daos.UserSettingsDao
import com.example.gymbuddy.data.entities.ArchivedTrainingModel
import com.example.gymbuddy.data.entities.ExerciseModel
import com.example.gymbuddy.data.entities.TrainingPlanModel
import com.example.gymbuddy.data.entities.UserSetting

@Database(entities =
        [UserSetting::class,
        TrainingPlanModel::class,
        ArchivedTrainingModel::class,
        ExerciseModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserSettingsDao
    abstract fun ExercisesDao(): ExercisesDao
    abstract fun TrainingsDao(): TrainingsDao

    companion object {
        private const val Database_NAME = "GymBuddy.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        Database_NAME
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}