package com.battermind.aug2024bootcamp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.battermind.aug2024bootcamp.database.model.ProgramModel

@Dao
interface ProgramDao {
    @Query("SELECT * FROM program_model order by title")
    fun getAll(): List<ProgramModel>

    @Query("SELECT * FROM program_model WHERE id IN (:ids)")
    fun loadAllByIds(ids: LongArray): List<ProgramModel>

    @Insert
    fun insert(vararg programModel: ProgramModel)

    @Insert
    fun insertAll(programModel: List<ProgramModel>)

    @Delete
    fun delete(programModel: ProgramModel)
}