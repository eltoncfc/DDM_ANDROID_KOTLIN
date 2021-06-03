package br.com.hair2u.hair2uapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProfissionalDAO {

    @Query("SELECT * FROM profissional where id = :id")
    fun getById(id: Long): Profissional?

    @Query("SELECT * FROM profissional")
    fun findAll(): List<Profissional>

    @Insert
    fun insert(profissional: Profissional)

    @Delete
    fun delete(profissional: Profissional)


}