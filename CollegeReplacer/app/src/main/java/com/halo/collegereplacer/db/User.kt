package com.halo.collegereplacer.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by James on 2019/3/9.
 * Desc:
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    var userId: String,
    var name: String,
    var age: Int
)