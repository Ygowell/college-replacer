package com.halo.collegereplacer.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.halo.collegereplacer.db.UserDao

/**
 * Created by James on 2019/3/9.
 * Desc:
 */
class UserViewModelFactory(private val userDao: UserDao):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}