package com.halo.collegereplacer.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import io.reactivex.Observable

/**
 * Created by James on 2019/3/9.
 * Desc:
 */
@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Observable<List<User>>

    @Query("SELECT * FROM users WHERE name LIKE :name" )
    fun getUsers(name: String): Observable<List<User>>

    @Query("SELECT * FROM users WHERE user_id = :id")
    fun getUserById(id: String): User
}