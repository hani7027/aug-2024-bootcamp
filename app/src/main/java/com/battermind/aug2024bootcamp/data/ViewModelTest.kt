package com.battermind.aug2024bootcamp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelTest  {
    private val _data = MutableLiveData<Int>()
    val data: LiveData<Int> get() = _data
    init {
        _data.value = 0 // Initialize the value to 0 or any other starting point
    }

    fun incrementCount() {
        _data.value = (_data.value ?: 0) + 1
    }
}