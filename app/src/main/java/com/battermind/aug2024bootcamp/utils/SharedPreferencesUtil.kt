package com.battermind.aug2024bootcamp.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesUtil {

    private const val PREFERENCES_FILE_KEY = "com.battermind.aug2024bootcamp"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)
    }

    fun putString(context: Context, key: String, value: String) {
        val sharedPreferences = getSharedPreferences(context)
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(context: Context, key: String, defaultValue: String? = null): String? {
        return getSharedPreferences(context).getString(key, defaultValue)
    }

    fun putInt(context: Context, key: String, value: Int) {
        val sharedPreferences = getSharedPreferences(context)
        with(sharedPreferences.edit()) {
            putInt(key, value)
            apply()
        }
    }

    fun getInt(context: Context, key: String, defaultValue: Int = 0): Int {
        return getSharedPreferences(context).getInt(key, defaultValue)
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {
        val sharedPreferences = getSharedPreferences(context)
        with(sharedPreferences.edit()) {
            putBoolean(key, value)
            apply()
        }
    }

    fun getBoolean(context: Context, key: String, defaultValue: Boolean = false): Boolean {
        return getSharedPreferences(context).getBoolean(key, defaultValue)
    }

    fun remove(context: Context, key: String) {
        val sharedPreferences = getSharedPreferences(context)
        with(sharedPreferences.edit()) {
            remove(key)
            apply()
        }
    }

    fun clear(context: Context) {
        val sharedPreferences = getSharedPreferences(context)
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
    }
}
