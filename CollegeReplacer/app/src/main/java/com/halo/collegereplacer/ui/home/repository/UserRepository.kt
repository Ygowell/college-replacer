package com.halo.collegereplacer.ui.home.repository

import com.halo.collegereplacer.api.ApiService
import com.halo.collegereplacer.db.User
import com.halo.collegereplacer.db.UserDao
import com.halo.collegereplacer.repository.IDataCallback
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
class UserRepository(private val apiService: ApiService, private val userDao: UserDao) {

    private lateinit var callback: IDataCallback<List<User>>

    fun loadDataFirstly() {
        userDao.getAllUsers()
            .flatMap {
                callback.onSuccess(it)
                callback.onLoading()
                apiService.getUser("")
            }.flatMap {
                if (!it.isNullOrEmpty()) {
                    for (user in it) {
                        userDao.insertUser(user)
                    }
                }
                Observable.just(it)
            }.subscribeOn(Schedulers.io())
            .subscribe(
                {
                    if (it.isNullOrEmpty()) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(it)
                    }
                },
                {
                    callback.onFail(it?.message)
                }
            )
    }

    fun loadData(isRefresh: Boolean) {
        apiService.getUser("")
            .flatMap {
                if (isRefresh && !it.isNullOrEmpty()) { // 刷新才更新数据库
                    for (user in it) {
                        userDao.insertUser(user)
                    }
                }
                Observable.just(it)
            }.subscribeOn(Schedulers.io())
            .subscribe(
                {
                    if (it.isNullOrEmpty()) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(it)
                    }
                },
                {
                    callback.onFail(it?.message)
                }
            )
    }


    fun setDataCallback(callback: IDataCallback<List<User>>) {
        this.callback = callback
    }
}