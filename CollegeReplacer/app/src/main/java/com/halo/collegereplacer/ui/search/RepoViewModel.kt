package com.halo.collegereplacer.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.halo.collegereplacer.model.Repo

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
class RepoViewModel(private val githubRepository: GithubRepository) : ViewModel() {

    private val _repoList = mutableListOf<Repo>()

    private val _repos = MutableLiveData<List<Repo>>().apply { value = _repoList }

    private val _errorMsg = MutableLiveData<String>()

    var query = ""

    val repos: MutableLiveData<List<Repo>>
        get() = _repos

    val errorMsg = _errorMsg

    fun search() {
        githubRepository.search(query,
            {
                _repoList.clear()
                _repoList.addAll(it)
            },
            {
                _errorMsg.value = it
            }
        )
    }

    fun loadMore() {
        githubRepository.loadMore(
            {
                _repoList.addAll(it)
            },
            {
                _errorMsg.value = it
            }
        )
    }
}