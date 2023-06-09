package com.jaax.dogedex.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaax.dogedex.api.ApiResponsesStatus
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {
    private var _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>> get() = _dogList

    private var _status = MutableLiveData<ApiResponsesStatus<List<Dog>>>()
    val status: LiveData<ApiResponsesStatus<List<Dog>>> get() = _status

    private val dogRepository = DogRepository()

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {
            _status.value = ApiResponsesStatus.Loading()
            handleResponseStatus(dogRepository.downloadDogs())
        }
    }

    private fun handleResponseStatus(apiResponsesStatus: ApiResponsesStatus<List<Dog>>) {
        if(apiResponsesStatus is ApiResponsesStatus.Success) {
            _dogList.value = apiResponsesStatus.data
        }

        _status.value = apiResponsesStatus
    }
}