package com.battermind.aug2024bootcamp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.battermind.aug2024bootcamp.database.dao.InquiryDao
import com.battermind.aug2024bootcamp.database.dao.ProgramDao
import com.battermind.aug2024bootcamp.database.model.InquiryModel
import com.battermind.aug2024bootcamp.database.model.ProgramModel
import com.battermind.aug2024bootcamp.utils.getProgramData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [InquiryModel::class, ProgramModel::class], version = 2)
abstract class BetterMindDatabase : RoomDatabase() {
    abstract fun inquiryDao(): InquiryDao
    abstract fun programDao(): ProgramDao

    companion object AppDataBase {
        private var database: BetterMindDatabase? = null


        fun getDataBase(context: Context): BetterMindDatabase {
            return database ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BetterMindDatabase::class.java,
                    DATABASE_NAME
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                getDataBase(context).programDao().insertAll(getProgramData())
                            }
                        }
                    })
                    .build()

                database = instance
                instance
            }
        }

        private val MIGRATION_2_3 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Create a new table with the updated schema if needed
                // Ensure the new schema matches the existing one exactly, avoiding any extra columns
                database.execSQL(
                    "CREATE TABLE new_program_model (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                            "title TEXT NOT NULL, " +
                            "duration TEXT NOT NULL, " +
                            "description TEXT NOT NULL)"
                )

                // Copy data from the old table to the new table
                // Ensure you only include columns that are present in both schemas
                database.execSQL(
                    "INSERT INTO new_program_model (id, title, duration, description) " +
                            "SELECT id, title, duration, description FROM program_model"
                )

                // Remove the old table
                database.execSQL("DROP TABLE program_model")

                // Rename the new table to the old table's name
                database.execSQL("ALTER TABLE new_program_model RENAME TO program_model")
            }
        }

        private const val DATABASE_NAME = "batterMindLabs"
    }
}