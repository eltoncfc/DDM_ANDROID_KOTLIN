package br.com.Hair2u.Hair2u

import com.google.gson.GsonBuilder
import java.io.Serializable


class Produtos: Serializable {
    var id: Long = 0
    var nome = ""
    var servico = ""
    var foto = ""
    var valor = ""

    override fun toString(): String {
        return "Produto(nome= $nome)"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}

