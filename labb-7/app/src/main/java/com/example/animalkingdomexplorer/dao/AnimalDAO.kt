package com.example.animalkingdomexplorer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.animalkingdomexplorer.model.Animal
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDAO {
    @Insert
    suspend fun insertAnimal(animal: Animal)

    @Query("SELECT * FROM animal")
    fun getAllAnimals(): Flow<List<Animal>>

}