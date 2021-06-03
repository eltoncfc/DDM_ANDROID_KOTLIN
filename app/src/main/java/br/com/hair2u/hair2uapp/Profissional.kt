package br.com.hair2u.hair2uapp

import com.google.gson.GsonBuilder
import java.io.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profissional")
class Profissional: Serializable {

    @PrimaryKey
    var id: Long = 0
    var nome = ""
    var servico = ""
    var foto = ""
    var detalhe = ""


    override fun toString(): String {
        return "Profissional(nome= $nome)"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }

}