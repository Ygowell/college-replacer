package com.halo.collegereplacer.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
class RepoViewModelFactory(private val githubRepository: GithubRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepoViewModel::class.java)) {
            return RepoViewModel(githubRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}