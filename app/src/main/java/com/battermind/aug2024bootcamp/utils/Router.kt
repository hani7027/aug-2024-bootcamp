package com.battermind.aug2024bootcamp.utils

import androidx.navigation.NavController
import com.battermind.aug2024bootcamp.R

class Router(private val navController: NavController) {
    fun gotoHomeDashboard() {
        navController.navigate(R.id.action_splashScreenFragment_to_FirstFragment)
    }
}