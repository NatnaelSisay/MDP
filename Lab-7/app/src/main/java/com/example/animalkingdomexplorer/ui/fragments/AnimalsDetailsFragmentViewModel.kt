package com.example.animalkingdomexplorer.ui.fragments

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.animalkingdomexplorer.db.AppDatabase
import com.example.animalkingdomexplorer.model.Animal
import kotlinx.coroutines.launch

class AnimalsDetailsFragmentViewModel(val appDatabase : AppDatabase) : ViewModel(){
    val animals : LiveData<List<Animal>> = appDatabase.animalDao().getAllAnimals().asLiveData()
    fun insertAnimal( animal: Animal){
        viewModelScope.launch {
            appDatabase.animalDao().insertAnimal(animal)

        }
    }

    companion object {

        val Factory: (context : Context)-> ViewModelProvider.Factory ={
            viewModelFactory {
                initializer {
                    val appDatabase = AppDatabase.getInstance(it)
                    AnimalsDetailsFragmentViewModel(appDatabase)
                }
            }
        }
    }
}