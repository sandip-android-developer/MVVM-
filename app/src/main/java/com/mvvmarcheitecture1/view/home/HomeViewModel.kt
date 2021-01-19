package com.mvvmarcheitecture1.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mvvmarcheitecture1.service.model.response.User
import com.mvvmarcheitecture1.service.respository.RetrofitBuilder
import com.mvvmarcheitecture1.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    /*private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
*/

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getUSerData()))
        } catch (exceptions: Exception) {
            emit(Resource.error(data = null, msg = exceptions.message ?: "Error Occurred!"))
        }

    }

    private suspend fun getUSerData(
    ): List<User> {
        return withContext(Dispatchers.IO) {
            RetrofitBuilder.apiService.getUsers()
        }
    }
}