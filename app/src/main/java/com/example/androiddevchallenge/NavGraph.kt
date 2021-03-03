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
package com.example.androiddevchallenge

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.ui.utils.Navigator
import kotlinx.parcelize.Parcelize

sealed class Destination : Parcelable {
    @Parcelize
    object Home : Destination()

    @Immutable
    @Parcelize
    data class PetDetail(val petId: Long) : Destination()
}

class Actions(navigator: Navigator<Destination>) {
    val selectPet: (Long) -> Unit = { petId: Long ->
        navigator.navigate(Destination.PetDetail(petId))
    }

    val upPress: () -> Unit = {
        navigator.back()
    }
}
