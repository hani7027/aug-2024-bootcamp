package com.battermind.aug2024bootcamp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "program_model")
data class ProgramModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "duration") val duration: String,
    @ColumnInfo(name = "description") val description: String,
)
