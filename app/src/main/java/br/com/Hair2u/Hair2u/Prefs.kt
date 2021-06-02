package br.com.Hair2u.Hair2u

import android.content.SharedPreferences

object Prefs {

    private fun prefs(): SharedPreferences {
        val contexto = Hair2uApplication.getInstance().applicationContext
        return contexto.getSharedPreferences("HAIR2U_PREFS", 0)
    }


    fun setBoolean(flag: String, valor: Boolean) = prefs().edit().putBoolean(flag, valor).apply()
    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()
    fun setBoolean(flag: String) = prefs().getBoolean(flag, false)
    fun getString(flag: String) = prefs().getString(flag, "")

    }


