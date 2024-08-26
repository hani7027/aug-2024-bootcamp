package com.battermind.aug2024bootcamp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inquiry_model")
data class InquiryModel(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "fullName") val fullName: String,
    @ColumnInfo(name = "phoneNumber") val phoneNumber: String,
    @ColumnInfo(name = "countryCode") val countryCode: String,
    @ColumnInfo(name = "schoolName") val schoolName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "parentsEmail") val parentsEmail: String,
    @ColumnInfo(name = "currentGrade") val currentGrade: String,
    @ColumnInfo(name = "dedicatedTimePerWeek") val dedicatedTimePerWeek: String
)