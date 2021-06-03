package br.com.hair2u.hair2uapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities =  arrayOf(Profissional::class), version=1)
abstract  class hair2uDatabase: RoomDatabase(){
    abstract fun profissionalDAO(): ProfissionalDAO
}
