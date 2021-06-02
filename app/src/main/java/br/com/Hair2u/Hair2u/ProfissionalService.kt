package br.com.Hair2u.Hair2u

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ProfissionalService {


        val host = "https://fesousa.pythonanywhere.com"
        val TAG = "WS_LMSAPP"

        fun getDisciplina(): List<Profissional>{

            val url = "$host/disciplinas"
            val json = HttpHelper.get(url)
            Log.d(TAG, json)

            var disciplinas = parserJson<ArrayList<Profissional>>(json)

            return  disciplinas
        }

         fun saveDisciplina(disciplina: Profissional){
         val json = disciplina.toJson()
            HttpHelper.post("$host/disciplinas", json)
            return
        }


        inline fun < reified T> parserJson(json: String):T{

            val type = object: TypeToken<T>(){}.type
            return Gson().fromJson<T>(json, type)
        }

    }