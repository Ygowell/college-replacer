package com.halo.collegereplacer

import android.content.Context
import com.halo.collegereplacer.api.ApiService
import com.halo.collegereplacer.db.CRDatabase
import com.halo.collegereplacer.db.UserDao
import com.halo.collegereplacer.ui.home.viewmodel.UserViewModelFactory
import com.halo.collegereplacer.ui.search.GithubRepository
import com.halo.collegereplacer.ui.search.RepoViewModelFactory

object Injection {

    fun providerUserDao(context: Context): UserDao {
        return CRDatabase.getInstance(context).userDao()
    }

    fun providerUserViewModelFactory(context: Context): UserViewModelFactory {
        return UserViewModelFactory(providerUserDao(context))
    }

    fun providerApiService(): ApiService {
        return ApiService.create()
    }

    fun providerRepoViewModelFactory(context: Context): RepoViewModelFactory {
        val githubRepository = GithubRepository(providerApiService())
        return RepoViewModelFactory(githubRepository)
    }
}