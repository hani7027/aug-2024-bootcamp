package com.battermind.aug2024bootcamp.example.exampleList

import androidx.lifecycle.MutableLiveData

class ExampleData {
    private val exampleData = MutableLiveData<MutableList<ExampleModel>>()

    init {

        exampleData.value = mutableListOf()
    }

    fun insert(data: ExampleModel) {
        this.exampleData.value?.add(data)
    }


    fun insert(list: List<ExampleModel>) {
        this.exampleData.value?.addAll(list)
    }

    fun delete(data: ExampleModel) {
        this.exampleData.value?.remove(data)
    }

    fun getData(): MutableLiveData<MutableList<ExampleModel>> = exampleData
}