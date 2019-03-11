package com.halo.collegereplacer.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.halo.collegereplacer.db.User
import com.halo.collegereplacer.db.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.StringBuilder
import java.util.*

/**
 * Created by James on 2019/3/9.
 * Desc:
 */
class UserViewModel(private val userDao: UserDao) : ViewModel() {

    private val _userNames = MutableLiveData<String>()

    val allUserNames = _userNames

    fun saveUser(name: String) {
        val user = User(UUID.randomUUID().toString(), name, 20)
        GlobalScope.launch(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    fun getAllUsers() {
        GlobalScope.launch(Dispatchers.IO) {
            val users = userDao.getAllUsers()
            val userNamesBuilder = StringBuilder()
                users.map {
                    userNamesBuilder.append("${it.name}, ")
            }

            withContext(Dispatchers.Main) {
                _userNames.value = userNamesBuilder.toString()
            }
        }
    }
}