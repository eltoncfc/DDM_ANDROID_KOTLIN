package br.com.hair2u.hair2uapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profissionalobs.*

class ProfissionalObs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profissionalobs)

        /*setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Profissionais"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)*/


        var prof = intent.getSerializableExtra("Profissional") as Profissional

        campo_nome.text = prof.nome
        campo_descricao.text = prof.servico
        campo_valor_produto.text = prof.detalhe

        Picasso.with(this).load(prof.foto).fit().into(image_profissional)


    }


}