/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Pet

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
            breed = "Boxer",
            energyLevel = "High",
            size = "Large",
            image = "https://images.unsplash.com/photo-1593134257782-e89567b7718a",
            details = "Max is an easygoing boy! Max loves belly scratches and going on walks. It is rare for a stray to be so good on a leash, so somebody had spent time with him! He is well mannered; waits to be leashed and responds to basic commands. Interested in adopting?!"
        ),
        Pet(
            id = 1,
            name = "Rocky",
            gender = Gender.Female,
            origin = "",
            age = 1,
            breed = "Pug",
            energyLevel = "Moderate",
            size = "Small",
            image = "https://images.unsplash.com/photo-1537151672256-6caf2e9f8c95",
            details = "Rocky is an easygoing gal! Rocky loves belly scratches and going on walks. It is rare for a stray to be so good on a leash, so somebody had spent time with her! She is well mannered; waits to be leashed and responds to basic commands. Interested in adopting?!"
        ),
        Pet(
            id = 2,
            name = "Mega",
            gender = Gender.Female,
            origin = "",
            age = 3,
            breed = "Lab",
            energyLevel = "Moderate",
            size = "Large",
            image = "https://images.unsplash.com/photo-1543337676-7712b5028449",
            details = "Mega is an easygoing gal! Mega loves belly scratches and going on walks. It is rare for a stray to be so good on a leash, so somebody had spent time with her! She is well mannered; waits to be leashed and responds to basic commands. Interested in adopting?!"
        ),
        Pet(
            id = 3,
            name = "Charlie",
            gender = Gender.Male,
            origin = "",
            age = 6,
            breed = "Boxer",
            energyLevel = "Moderate",
            size = "Extra large",
            image = "https://images.unsplash.com/photo-1536910467852-a6fded0c5c47",
            details = "Charlie is an easygoing boy! Charlie loves belly scratches and going on walks. It is rare for a stray to be so good on a leash, so somebody had spent time with him! He is well mannered; waits to be leashed and responds to basic commands. Interested in adopting?!"
        ),
        Pet(
            id = 4,
            name = "Pug",
            gender = Gender.Female,
            origin = "",
            age = 3,
            breed = "Lab",
            energyLevel = "Moderate",
            size = "Large",
            image = "https://images.unsplash.com/photo-1592769606534-fe78d27bf450",
            details = "Pug is an easygoing gal! Pug loves belly scratches and going on walks. It is rare for a stray to be so good on a leash, so somebody had spent time with her! She is well mannered; waits to be leashed and responds to basic commands. Interested in adopting?!"
        ),
        // Harvey Dent
    )
    fun loadPets() = pets
    fun getPet(petId: Long): Pet = pets.find { it.id == petId }!!
}
