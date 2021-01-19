package com.mvvmarcheitecture1.service.respository

class MainRepository(val apiHelper: ApiService) {
    suspend fun getUsers() = apiHelper.getUsers()
  //  suspend fun getPhotos() = apiHelper.getPhotos()
}