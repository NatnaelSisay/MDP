package com.example.animalkingdomexplorer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animalkingdomexplorer.dao.AnimalDAO
import com.example.animalkingdomexplorer.dao.SpeciesDAO
import com.example.animalkingdomexplorer.model.Animal
import com.example.animalkingdomexplorer.model.Species

@Database(entities = [Animal::class, Species::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDAO
    abstract fun speciesDao(): SpeciesDAO

    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun getInstance(ctx : Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    AppDatabase::class.java,
                    "animal_kingdom_db"
                ).build()
            }
            return instance!!
        }
    }
}