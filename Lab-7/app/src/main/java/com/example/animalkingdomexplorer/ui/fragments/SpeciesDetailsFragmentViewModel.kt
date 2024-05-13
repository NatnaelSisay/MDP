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
import com.example.animalkingdomexplorer.model.Species
import kotlinx.coroutines.launch

class SpeciesDetailsFragmentViewModel(val appDatabase : AppDatabase) : ViewModel(){
    val species : LiveData<List<Species>> = appDatabase.speciesDao().getAllSpecies().asLiveData()
    fun insertSpecies( species: Species){
        viewModelScope.launch {
            appDatabase.speciesDao().insertSpecies(species)

        }
    }

    companion object {

        val Factory: (context : Context)-> ViewModelProvider.Factory ={
            viewModelFactory {
                initializer {
                    val appDatabase = AppDatabase.getInstance(it)
                    SpeciesDetailsFragmentViewModel(appDatabase)
                }
            }
        }
    }
}