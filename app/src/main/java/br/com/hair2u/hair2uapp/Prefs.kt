package br.com.hair2u.hair2uapp

import android.content.SharedPreferences

object Prefs {

    private fun prefs (): SharedPreferences {
        val contexto = ConfigApplication.getInstance().applicationContext
        return contexto.getSharedPreferences("SORV_PREFS", 0)
    }

    fun setBoolean (flag: String, valor: Boolean) = prefs().edit().putBoolean(flag, valor).apply()
    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()
    fun getBoolean(flag: String) = prefs().getBoolean(flag, false)
    fun getString(flag: String) = prefs().getString(flag, "")

}