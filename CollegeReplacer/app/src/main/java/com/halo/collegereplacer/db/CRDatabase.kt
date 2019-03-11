package com.halo.collegereplacer.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by James on 2019/3/9.
 * Desc:
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class CRDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

}