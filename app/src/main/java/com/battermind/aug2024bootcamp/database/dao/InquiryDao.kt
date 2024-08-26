package com.battermind.aug2024bootcamp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.battermind.aug2024bootcamp.database.model.InquiryModel

@Dao
interface InquiryDao {
    @Query("SELECT * FROM inquiry_model")
    fun getAll(): List<InquiryModel>

    @Query("SELECT * FROM inquiry_model WHERE id IN (:inquiryIds)")
    fun loadAllByIds(inquiryIds: IntArray): List<InquiryModel>

    @Insert
    fun insertAll(vararg inquiry: InquiryModel)

    @Delete
    fun delete(inquiry: InquiryModel)
}