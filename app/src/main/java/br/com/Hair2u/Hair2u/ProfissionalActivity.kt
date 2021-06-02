package br.com.Hair2u.Hair2u

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.layoutMenuLateral
import kotlinx.android.synthetic.main.activity_home.menu_lateral
import kotlinx.android.synthetic.main.activity_profissional.*
import kotlinx.android.synthetic.main.toolbar.*


class ProfissionalActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var profissional = listOf<Profissional>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profissional)

        val intent_voltar_home = Intent(this, HomeActivity::class.java)

        button_voltar_para_home.setOnClickListener {
            startActivity(intent_voltar_home)
        }

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Profissional"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
        recycleProfissional?.layoutManager = LinearLayoutManager(this)
        recycleProfissional?.itemAnimator = DefaultItemAnimator()
        recycleProfissional?.setHasFixedSize(true)
        menu_lateral.setCheckedItem(R.id.nav_profissional)
    }

    override fun onResume() {
        super.onResume()
        taskProfissional()
    }


    private fun taskProfissional() {

        Thread {
            this.profissional = ProfissionalService.getDisciplina()
            runOnUiThread {
                recycleProfissional?.adapter =
                    ProfissionalAdapter(this.profissional) { onClickProfissional(it) }
            }
        }.start()

    }

    fun onClickProfissional(profissional2: Profissional) {
        Toast.makeText(context, "Clicou Profissional ${profissional2.nome}", Toast.LENGTH_SHORT)
            .show()
        val intent = Intent(context, ProfissionalAdapter::class.java)
        intent.putExtra("Profissional", profissional2)
        startActivityForResult(intent, REQUEST_REMOVE)

        /*fun onClickProfissional(profissional1: Profissional){
        Toast.makeText(this, "Clicou no Profissional! ${profissional1.nome}", Toast.LENGTH_SHORT).show()*/

    }

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_servicos -> {
                var intent_servicos = Intent(this, ServicosActivity::class.java)
                startActivity(intent_servicos)
                Toast.makeText(this, "Clicou no Serviço", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_profissional -> {
                var intent_prfissional = Intent(this, ProfissionalActivity::class.java)
                startActivity(intent_prfissional)
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_produtos -> {
                var intent_produtos = Intent(this, ProdutosActivity::class.java)
                startActivity(intent_produtos)
                Toast.makeText(this, "Clicou no Produtos", Toast.LENGTH_SHORT).show()
            }

        }

        layoutMenuLateral.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            val intent = Intent(context, ProfissionalActivity::class.java)
            startActivityForResult(intent, REQUEST_CADASTRO)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CADASTRO || requestCode == REQUEST_REMOVE) {
            // atualizar lista de disciplinas
            taskProfissional()
        }

    }
}

