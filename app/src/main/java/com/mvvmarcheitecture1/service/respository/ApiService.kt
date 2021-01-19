package com.mvvmarcheitecture1.service.respository

import com.mvvmarcheitecture1.service.model.response.PhotoListResponse
import com.mvvmarcheitecture1.service.model.response.User
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users")
    suspend fun getPhotos(@Query("page") pageNumber:Int/*,
    @Query("pageSize") limit:Int=20*/) :PhotoListResponse

 }