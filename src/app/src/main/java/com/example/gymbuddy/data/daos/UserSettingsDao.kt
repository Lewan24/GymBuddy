package com.example.gymbuddy.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.gymbuddy.data.entities.UserSetting

@Dao
interface UserSettingsDao {
    @Query("SELECT * FROM UserSettings")
    fun GetAllSettings() : List<UserSetting>
}