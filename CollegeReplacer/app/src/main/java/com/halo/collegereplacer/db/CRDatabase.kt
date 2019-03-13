package com.halo.collegereplacer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by James on 2019/3/9.
 * Desc:
 */
@Database(entities = [User::class], version = 1)
abstract class CRDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile private var INSTANCE: CRDatabase? = null

        fun getInstance(context: Context): CRDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context)
            }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                    CRDatabase::class.java, "college_replace.db")
                    .build()
    }
}