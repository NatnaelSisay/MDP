package com.example.animalkingdomexplorer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Species (
    @PrimaryKey
    val uid: Int?,
    val speciesName: String,
    val speciesDescription: String
)