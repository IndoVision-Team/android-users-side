package com.indovision.belanja.data.source.local

import android.content.Context

internal class UserPreference(context: Context) {
    companion object{
        private const val PREF_NAME = "belanja"
        private const val EMAIL = "email"
    }

    private val preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setUserEmail(email: String){
        val editor = preference.edit()
        editor.putString(EMAIL, email)
        editor.apply()
    }

    fun getUserEmail(): String = preference.getString(EMAIL, "") as String

}