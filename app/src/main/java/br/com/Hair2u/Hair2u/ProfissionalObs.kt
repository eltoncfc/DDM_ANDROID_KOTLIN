package br.com.Hair2u.Hair2u

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profissionalobs.*
import kotlinx.android.synthetic.main.activity_profissionalobs.*
import kotlinx.android.synthetic.main.activity_profissionalobs.campo_nome
import kotlinx.android.synthetic.main.toolbar.*


class ProfissionalObs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profissionalobs)

        var produtos = intent.getSerializableExtra("Profissional") as Profissional


        campo_nome.text = produtos.nome

        Picasso.with(this).load(produtos.foto).fit().into(image_profissional)
    }

}












/*
class ProfissionalObs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profissionalobs)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Profissionais"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var prof = intent.getSerializableExtra("profissional") as Profissional

        campo_nome.text = prof.nome
        campo_descricao.text = prof.servico
        campo_valor_produto.text = prof.valor

        Picasso.with(this).load(prof.foto).fit().into(image_profissional)


    }


}*/
