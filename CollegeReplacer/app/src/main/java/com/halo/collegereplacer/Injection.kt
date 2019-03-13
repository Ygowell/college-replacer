package com.halo.collegereplacer

import android.content.Context
import com.halo.collegereplacer.api.ApiReq
import com.halo.collegereplacer.api.ApiService
import com.halo.collegereplacer.db.CRDatabase
import com.halo.collegereplacer.db.UserDao
import com.halo.collegereplacer.ui.home.viewmodel.UserViewModelFactory

object Injection {

    fun providerUserDao(context: Context): UserDao {
        return CRDatabase.getInstance(context).userDao()
    }

    fun providerUserViewModelFactory(context: Context) : UserViewModelFactory {
        return UserViewModelFactory(providerUserDao(context))
    }

    fun providerApiService(): ApiService {
        return ApiReq.provideApiService()
    }
}