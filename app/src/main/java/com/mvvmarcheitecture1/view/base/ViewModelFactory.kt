package com.mvvmarcheitecture1.view.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvmarcheitecture1.service.respository.ApiService
import com.mvvmarcheitecture1.view.home.HomeViewModel

 class ViewModelFactory(val apiHelper: ApiService):ViewModelProvider.Factory {
     override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
             return HomeViewModel(/*MainRepository(apiHelper)*/) as T
         }
         throw IllegalArgumentException("Unknown class name")
     }
}