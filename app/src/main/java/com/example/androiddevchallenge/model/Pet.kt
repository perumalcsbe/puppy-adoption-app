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
package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable

@Immutable
data class Pet(
    val id: Long,
    val name: String,
    val origin: String,
    val age: Int,
    val gender: Gender,
    val breed: String,
    val energyLevel: String,
    val size: String,
    val image: String = "https://images.unsplash.com/photo-1593134257782-e89567b7718a",
    val details: String = "Hi! I'm new here. Everyone's still getting to know me."
)

enum class Gender {
    Male,
    Female
}
