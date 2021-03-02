package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable

@Immutable
data class Pet(
    val id: Long,
    val name: String,
    val origin: String,
    val age: Int,
    val gender: Gender,
    val breed: Breed,
    val energyLevel: EnergyLevel,
    val size: Size,
    val image: String = "https://images.unsplash.com/photo-1593134257782-e89567b7718a",
    val details: String =  ""
)
enum class Size {
    Small,
    Medium,
    Large,
    ExtraLarge
}
enum class EnergyLevel {
    Low,
    High,
    Moderate
}

enum class Gender {
    Male,
    Female
}

enum class Breed {
    Beagle,
    Bulldog,
    Dachshund,
    Pug,
    Terrior,
    Boxer
}