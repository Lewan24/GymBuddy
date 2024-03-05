package com.example.gymbuddy.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserSettings")
data class UserSetting(
    @PrimaryKey @ColumnInfo(name="Id") val id: Int = 0
)
