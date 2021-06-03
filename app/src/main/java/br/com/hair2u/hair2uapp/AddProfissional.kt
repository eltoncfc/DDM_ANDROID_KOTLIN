package br.com.hair2u.hair2uapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_addprodutos.*

class AddProfissional : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addprodutos)

        supportActionBar?.title = "Adicionar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        salvarProfissional.setOnClickListener {
            val profissionais = Profissional()
            profissionais.nome = nomeProfissional.text.toString()
            profissionais.detalhe = tiposServicos.text.toString()
            profissionais.detalhe = especialidade.text.toString()
            profissionais.foto = urlFoto.text.toString()

            taskAtualizar(profissionais)
        }

    }

    private fun taskAtualizar(profissionais: Profissional) {
        // Thread para salvar a produto
        Thread {
            ProfissionalService.profSave(profissionais)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }


        return super.onOptionsItemSelected(item)
    }


}