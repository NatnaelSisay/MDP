package com.example.animalkingdomexplorer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.animalkingdomexplorer.model.Species
import kotlinx.coroutines.flow.Flow


@Dao
interface SpeciesDAO {
    @Insert
    suspend fun insertSpecies(species: Species)

    @Query("SELECT * FROM species")
    fun getAllSpecies(): Flow<List<Species>>

}