package br.com.hair2u.hair2uapp

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    val TAG = "HAIR2U_FB"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "TOKEN_FB $token")

        Prefs.setString("TOKEN_FB", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?){
        super.onMessageReceived(mensagemRemota)

        if(mensagemRemota?. notification != null){
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Título: $titulo")
            Log.d(TAG, "Corpo: $corpo")

            if(mensagemRemota?.data.isNotEmpty()){
                val produtosID = mensagemRemota.data.get("produtosId")
                Log.d(TAG,"Id da Disciplina $produtosID")
                val d = ProfissionalService.getById(produtosID!!.toInt())

                val intent = Intent(this, ProdutosActivity::class.java)
                intent.putExtra("produtos", d)
                NotificationUtil.create(1, intent, titulo!!, corpo!!)
            }

        }


    }

}