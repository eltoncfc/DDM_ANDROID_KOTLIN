package br.com.hair2u.hair2uapp

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: hair2uDatabase

    init{
        val context = ConfigApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            hair2uDatabase::class.java,
            "hair2u.sqlite"
        ).build()
    }
    fun getProfissionalDAO(): ProfissionalDAO {
        return  dbInstance.profissionalDAO()
    }

}