package com.halo.collegereplacer.repository

/**
 * Created by James on 2019/3/16.
 * Desc:
 */
interface IDataCallback<T> {
    fun onSuccess(data: T)

    fun onFail(error: String?)

    fun onEmpty()

    fun onLoading()
}