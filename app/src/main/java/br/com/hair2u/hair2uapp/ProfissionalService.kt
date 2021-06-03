package br.com.hair2u.hair2uapp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ProfissionalService {
    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "Hair2uApp"



    fun getById(id: Int): Profissional {
        val url = "$host/disciplinas/$id"
        val json = HttpHelper.get(url)
        return parserJson(json)
    }



    fun getProfissional(): List<Profissional> {
           var profissional = ArrayList<Profissional>()
            val url = "$host/disciplinas"
            val json = HttpHelper.get(url)
             profissional = parserJson(json)


      /*  val dao = DatabaseManager.getProfissionalDAO()
        val profissional = dao.findAll()*/

        return profissional
    }

    fun profSave(profissionais: Profissional) {

        val dao = DatabaseManager.getProfissionalDAO()
        dao.insert(profissionais)

    }

    inline fun <reified T> parserJson(json: String): T {

        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }

}
