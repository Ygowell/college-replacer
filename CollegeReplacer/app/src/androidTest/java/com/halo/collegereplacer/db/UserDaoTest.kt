package com.halo.collegereplacer.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by James on 2019/3/9.
 * Desc:
 */
@RunWith(AndroidJUnit4::class)
class UserDaoTest {
    private lateinit var crDatabase: CRDatabase

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initDb() {
        crDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getContext(),
            CRDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
    }

    @Test
    fun getAllUsersWhenNoUserInserted() {
        val userList = crDatabase.userDao().getAllUsers()
        assert(userList.isEmpty())
    }

    @Test
    fun insertUser() {
        crDatabase.userDao().insertUser(USER)

        val user = crDatabase.userDao().getUserById("1000")
        assert(user.name == "Jim")
    }

    @After
    fun closeDb() {
        crDatabase.close()
    }

    companion object {

        private val USER = User("1000", "Jim", 18)
    }
}