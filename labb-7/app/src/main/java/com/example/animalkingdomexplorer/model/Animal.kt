package com.example.animalkingdomexplorer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Animal (
    @PrimaryKey
    val uid: Int?,
    val animalName: String,
    val habitat: String,
    val diet : String
)