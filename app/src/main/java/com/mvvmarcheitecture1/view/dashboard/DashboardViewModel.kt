package com.mvvmarcheitecture1.view.dashboard

import androidx.lifecycle.*
import androidx.paging.*
import com.mvvmarcheitecture1.service.model.response.PhotoListResponse
import com.mvvmarcheitecture1.service.respository.ApiService
import com.mvvmarcheitecture1.service.respository.RetrofitBuilder
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException

class DashboardViewModel(/*var mainRepository: PhotoRepository*/) : ViewModel() {
   /* private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text*/

    /*fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getUSerData()))
        } catch (exceptions: Exception) {
            emit(Resource.error(data = null, msg = exceptions.message ?: "Error Occurred!"))
        }

    }*/
    val photoList: Flow<PagingData<PhotoListResponse>> = Pager(PagingConfig(pageSize = 20)) {
        PhotoPagingSouce(RetrofitBuilder.apiService)
    }.flow
        .cachedIn(viewModelScope)

  /*  private fun getPhotosData(): ApiService {
        return withContext(Dispatchers.IO) {
            RetrofitBuilder.apiService.getPhotos(1,2)
        }
    }*/

    /*fun photoRepo(): Flow<PagingData<PhotoListResponse>> {

        val newResult = mainRepository.getPhotos().flow.cachedIn(viewModelScope)

        return newResult
    }*/
    class PhotoPagingSouce(val apiService: ApiService) : PagingSource<Int, PhotoListResponse>() {
        var STARTING_PAGE_INDEX = 1
        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoListResponse> {
            try {
                var nextPage=params.key?:STARTING_PAGE_INDEX
                var response= listOf(apiService.getPhotos(nextPage))
                return LoadResult.Page(data = response,
                prevKey = if (nextPage==1) null else nextPage-1,
                nextKey =/* if (response.isEmpty()) null else */nextPage + 1)

            } catch (e: Exception) {
                println("Issue---"+e.message)
                return LoadResult.Error(e)
            }
            catch (e: HttpException) {
                println("Issue---1--"+e.message)
                // HttpException for any non-2xx HTTP status codes.
                return LoadResult.Error(e)
            }

        }

    }

   /*  suspend fun getPhotosData(
    ): ApiService {
        return withContext(Dispatchers.IO) {
            RetrofitBuilder.apiService
        }
    }*/
}