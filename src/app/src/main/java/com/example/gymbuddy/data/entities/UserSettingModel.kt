package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserSettings")
data class UserSetting(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="Id") val id: Int = 0,
    @ColumnInfo(name="SettingName") val settingName: String,
    @ColumnInfo(name="SettingValue") val settingValue: String
)
