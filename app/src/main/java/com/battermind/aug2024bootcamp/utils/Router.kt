package com.battermind.aug2024bootcamp.utils

import androidx.navigation.NavController
import com.battermind.aug2024bootcamp.R

class Router(private val navController: NavController) {
    fun gotoHomeDashboard() {
        navController.navigateUp()
        navController.navigate(R.id.action_global_to_userDashboardFragment)
    }
    fun gotoFirstFragment() {
        navController.navigateUp()
        navController.navigate(R.id.action_global_to_firstFragment)
    }
    fun gotoSecondFragment() {
        navController.navigate(R.id.action_global_to_secondFragment)
    }

    fun gotoProgramList() {
        navController.navigate(R.id.action_global_to_programList)
    }
    fun gotoProgramDetail() {
        navController.navigate(R.id.action_global_to_programDetailFragment)
    }
    fun gotoAddNewProgram() {
        navController.navigate(R.id.action_global_to_addNewProgramFragment)
    }



    fun gotoAdminLogin() {
        navController.navigate(R.id.action_global_to_loginFragment)
    }
    fun gotoAdminDashboard() {
        navController.navigate(R.id.action_global_to_adminDashboard)
    }
    fun gotoInquiryForm() {
        navController.navigate(R.id.action_global_to_inquiryFormFragment)
    }
    fun gotoInquiryList() {
        navController.navigate(R.id.action_global_to_inquiryListFragment)
    }
    fun gotoInquiryDetail() {
        navController.navigate(R.id.action_global_to_inquiryDetailsFragment)
    }

    fun gotoContactUs() {
        navController.navigate(R.id.action_global_to_contactUs)
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}