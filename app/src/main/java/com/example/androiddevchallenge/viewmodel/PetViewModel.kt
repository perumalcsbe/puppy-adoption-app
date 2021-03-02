package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.repository.PetRepository

class PetViewModel: ViewModel() {
    var pets: List<Pet> = listOf()

    init {
        pets =  PetRepository.loadPets()
    }

}