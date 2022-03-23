package com.roshan.alexbd.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roshan.alexbd.data.BirthdayRepository
import com.roshan.alexbd.data.Response
import com.roshan.alexbd.ui.ListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository:
    BirthdayRepository
) : ViewModel() {
    var birthdayListLiveData: MutableLiveData<Response> = MutableLiveData()
     val listState = MutableLiveData<ListState>()
    fun makeBirthdayListAPICall() {
        viewModelScope.launch {
            repository.getList().collect { buildList(it) }
        }

    }

    private fun buildList(list: Response) {
        if (list.response.isNullOrEmpty()) {
            listState.value = ListState.Empty

        } else {
            birthdayListLiveData.postValue(list)
            listState.value = ListState.Loaded
        }
    }


}