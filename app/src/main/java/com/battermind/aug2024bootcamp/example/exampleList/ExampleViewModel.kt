package com.battermind.aug2024bootcamp.example.exampleList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel : ViewModel() {

    init {
        Log.e("ViewModel","Init")
    }

    // LiveData list to hold ExampleModel items
    private val _exampleList = MutableLiveData<List<ExampleModel>>()
    val exampleList: LiveData<List<ExampleModel>> get() = _exampleList
    init {
        // Initialize the list with some data
        _exampleList.value = listOf(
            ExampleModel(1, "Title 1", "SubTitle 1"),
            ExampleModel(2, "Title 2", "SubTitle 2"),
        )
    }


    // Function to update the list
    fun updateList(newList: List<ExampleModel>) {
        _exampleList.value = newList
    }
}