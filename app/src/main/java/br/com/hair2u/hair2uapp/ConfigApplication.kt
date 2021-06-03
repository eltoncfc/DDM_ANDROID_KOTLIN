package br.com.hair2u.hair2uapp


import android.app.Application

class ConfigApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: br.com.hair2u.hair2uapp.ConfigApplication? = null

        fun getInstance(): br.com.hair2u.hair2uapp.ConfigApplication {
            if (appInstance == null) {
                 throw IllegalMonitorStateException("Configurar application no Manifest")
             }
            return appInstance!!
        }
    }
}