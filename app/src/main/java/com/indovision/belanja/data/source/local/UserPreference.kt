package com.indovision.belanja.data.source.local

import android.content.Context

internal class UserPreference(context: Context) {
    companion object{
        private const val PREF_NAME = "belanja"
        private const val EMAIL = "email"
        private const val USER_ID = "userId"
    }

    private val preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setUser(email: String, userId: String){
        val editor = preference.edit()
        editor.putString(EMAIL, email)
        editor.putString(USER_ID, userId)
        editor.apply()
    }

    fun getUserEmail(): String = preference.getString(EMAIL, "") as String

    fun getUserId(): String = preference.getString(USER_ID, "") as String

}