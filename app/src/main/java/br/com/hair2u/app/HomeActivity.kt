package br.com.hair2u.app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val args = intent.extras
        val usuario = args?.getString("usuario")
        val numero = args?.getString("senha")

        Toast.makeText(this, usuario, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, numero, Toast.LENGTH_SHORT).show()

        user_home.text = "Bem-vindo $usuario"


        button_home.setOnClickListener{
            var intent_home = Intent(this, MainActivity::class.java)
            startActivity(intent_home)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_bar_search -> Toast.makeText(this,"Pesquisar",Toast.LENGTH_SHORT).show()
            R.id.nav_bar_update -> Toast.makeText(this,"Atualizar",Toast.LENGTH_SHORT).show()
            R.id.nav_bar_add -> Toast.makeText(this,"Adicionar",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)

    }
}