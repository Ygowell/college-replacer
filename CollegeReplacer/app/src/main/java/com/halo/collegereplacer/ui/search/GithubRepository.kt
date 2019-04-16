package com.halo.collegereplacer.ui.search

import com.halo.collegereplacer.api.ApiService
import com.halo.collegereplacer.model.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
class GithubRepository(private val apiService: ApiService) {

    private var lastReqPage = 1

    private var isLoading = false

    private lateinit var query: String

    fun search(
        query: String,
        onSuccess: (repoList: List<Repo>) -> Unit,
        onError: (error: String) -> Unit) {
        lastReqPage = 1
        this.query = query
        loadData(query, onSuccess, onError)
    }

    fun loadMore(
        onSuccess: (repoList: List<Repo>) -> Unit,
        onError: (error: String) -> Unit
    ) {
        lastReqPage++
        loadData(query, onSuccess, onError)
    }

    private fun loadData(
        query: String,
        onSuccess: (repoList: List<Repo>) -> Unit,
        onError: (error: String) -> Unit
    ) {
        if(isLoading) return

        isLoading = true
        apiService.searchRepos(query, lastReqPage, 20)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onSuccess(it.items)
                    isLoading = false
                },
                {
                    onError(it?.message ?: "Error")
                    isLoading = false
                }
            )
    }
}