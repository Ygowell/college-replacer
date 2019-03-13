package com.halo.collegereplacer.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by James on 2019/3/7.
 * Desc:
 */
object ApiReq {

    private lateinit var apiService: ApiService

    private val BASE_URL = "https://api.xxx.xxx" // TODO: replace

    fun provideApiService(): ApiService {
        if (apiService == null) {
            apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
        }
        return apiService
    }
}