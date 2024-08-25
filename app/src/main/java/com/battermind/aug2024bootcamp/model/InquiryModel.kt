package com.battermind.aug2024bootcamp.model

data class InquiryModel(
    val id: Long,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val city: String,
    val parentEmail: String,
    val timezone: String,
    val dedicatePerWeek: String,
)