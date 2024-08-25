package com.battermind.aug2024bootcamp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class InquiryData {
    private val inquiryList = MutableLiveData<MutableList<InquiryModel>>()

    init {

        inquiryList.value = mutableListOf()
    }

    fun insert(data: InquiryModel) {
        inquiryList.value?.add(data)
    }

    fun delete(data: InquiryModel) {
        inquiryList.value?.remove(data)
    }

    fun getData() = inquiryList
}