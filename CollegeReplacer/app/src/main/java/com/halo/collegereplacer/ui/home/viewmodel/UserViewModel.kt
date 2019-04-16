package com.halo.collegereplacer.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.halo.collegereplacer.db.User
import com.halo.collegereplacer.db.UserDao
import io.reactivex.schedulers.Schedulers
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

    private val userList = mutableListOf<User>()

    private val _users = MutableLiveData<List<User>>().apply { value = userList }

    private val _userNames = MutableLiveData<String>()

    val allUserNames = _userNames

    val users: MutableLiveData<List<User>>
        get() = _users

    var inputText = MutableLiveData<String>()

    fun saveUser() {
        val user = User(UUID.randomUUID().toString(), inputText.value.toString(), 20)
        GlobalScope.launch(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    fun getAllUsers() {
        userDao.getAllUsers()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    val userNamesBuilder = StringBuilder()
                    it.map { user ->
                        userNamesBuilder.append("${user.name}, ")
                    }
                    userList.addAll(it)
                    _userNames.value = userNamesBuilder.toString()
                },
                {

                }
            )
    }
}