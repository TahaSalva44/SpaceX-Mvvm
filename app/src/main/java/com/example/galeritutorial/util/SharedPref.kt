package com.example.galeritutorial.util

import android.content.Context

object SharedPref {
    val YEAR = "YEAR"

    fun putInt(context: Context, key: String, value: Int?) {
        val pref = context.getSharedPreferences(YEAR, Context.MODE_PRIVATE)
        pref.edit().putInt(key, value!!).apply()
    }

    fun getInt(context: Context, key: String, defValue: Int?): Int {
        val pref = context.getSharedPreferences(YEAR, Context.MODE_PRIVATE)
        return pref.getInt(key, defValue!!)
    }
}