package com.eni.database

import androidx.room.*

@Dao
interface VilleDao {
    @Insert
    fun insert(ville: Ville)

    @Query("SELECT * FROM Ville")
    fun getAll() : List<Ville>

    @Update
    fun update(ville: Ville)

    @Delete
    fun delete(ville: Ville)
}