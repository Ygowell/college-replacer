package com.halo.collegereplacer.api

import com.halo.collegereplacer.db.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by James on 2019/3/7.
 * Desc:
 */
interface ApiService {

    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Observable<User>
}