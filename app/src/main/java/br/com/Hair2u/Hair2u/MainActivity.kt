package br.com.Hair2u.Hair2u

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        imageview_login.setImageResource(R.drawable.cab)

        botao_login.setOnClickListener{
            val user  = input_user.text.toString()
            val password = input_password.text.toString()
            var intent = Intent(this, HomeActivity::class.java)
            var parametros = Bundle()
            parametros.putString("Usuario", user)
            parametros.putString("Senha", password)
            if (user.equals("") && password.equals("")){
                Toast.makeText(this, "Campo Usuário ou  Campo Senha vazios !", Toast.LENGTH_LONG).show()
            } else if (user.equals("aluno") && password.equals("impacta")){
                Toast.makeText(this, "Login Efetuado com Sucesso!", Toast.LENGTH_SHORT).show()
                intent.putExtras(parametros)
                //intent.putExtra("double", 1.75)
                startActivity(intent)
            } else{Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show() }

        }
    }

}