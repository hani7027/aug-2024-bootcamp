package com.battermind.aug2024bootcamp.example

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel : ViewModel() {

    private val _count = MutableLiveData<Int>()

    val count: LiveData<Int> get() = _count

    init {
        Log.e("view","viewModel")
        _count.value = 0
    }

    fun increaseCount() {
        _count.value = (_count.value ?: 0) + 1
    }
}