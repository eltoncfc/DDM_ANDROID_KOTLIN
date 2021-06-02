package br.com.Hair2u.Hair2u

import android.app.Application

class Hair2uApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        appIntance = this

}
    companion object {
        private var appIntance: Hair2uApplication? = null

        fun getInstance(): Hair2uApplication {
            if (appIntance == null) {
                throw IllegalAccessException("Configurar aplication no Manifest")
            }
            return appIntance!!
        }
    }

}