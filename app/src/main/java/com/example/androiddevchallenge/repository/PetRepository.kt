package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.model.*


// Fake Repository

object PetRepository {
    // Fake data
    private val pets = listOf(
        Pet(
            id = 0,
            name = "Max",
            gender = Gender.Male,
            origin = "",
            age = 1,
            breed = Breed.Boxer,
            energyLevel = EnergyLevel.High,
            size = Size.Large,
            image = "https://images.unsplash.com/photo-1593134257782-e89567b7718a"
        ),
        Pet(
            id = 1,
            name = "Rocky",
            gender = Gender.Female,
            origin = "",
            age = 1,
            breed = Breed.Pug,
            energyLevel = EnergyLevel.Moderate,
            size = Size.Small,
            image = "https://images.unsplash.com/photo-1537151672256-6caf2e9f8c95"
        ),
        Pet(
            id = 1,
            name = "Rocky",
            gender = Gender.Female,
            origin = "",
            age = 1,
            breed = Breed.Pug,
            energyLevel = EnergyLevel.Moderate,
            size = Size.Small,
            image = "https://images.unsplash.com/photo-1543337676-7712b5028449"
        ),
        Pet(
            id = 1,
            name = "Charlie",
            gender = Gender.Male,
            origin = "",
            age = 1,
            breed = Breed.Pug,
            energyLevel = EnergyLevel.Moderate,
            size = Size.Small,
            image = "https://images.unsplash.com/photo-1536910467852-a6fded0c5c47"
        )
    //Harvey Dent
    )
    fun loadPets() = pets
    fun getPet(petId: Long): Pet = pets.find { it.id == petId }!!
}