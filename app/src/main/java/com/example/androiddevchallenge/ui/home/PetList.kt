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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.common.PetAdaptionAppBar
import com.example.androiddevchallenge.ui.petDetail.FavButton
import com.example.androiddevchallenge.ui.theme.PetTheme
import com.example.androiddevchallenge.ui.theme.primaryColor
import com.example.androiddevchallenge.ui.utils.NetworkImage

@Composable
fun PetList(
    pets: List<Pet>,
    selectPet: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        item {
            PetAdaptionAppBar()
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        itemsIndexed(pets) { _, pet ->
            PetItem(pet, selectPet)
        }
    }
}

@Composable
fun PetItem(pet: Pet, selectPet: (Long) -> Unit) {
    val iconVector = if (pet.gender == Gender.Male) Icons.Rounded.Male else Icons.Rounded.Female
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { selectPet(pet.id) })
            .padding(8.dp),
        backgroundColor = primaryColor,
        elevation = 1.dp,
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp, topEnd = 8.dp, bottomEnd = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            NetworkImage(
                url = pet.image,
                contentDescription = "Pet image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape) // RoundedCornerShape(percent - 10)
                    .border(2.dp, Color.Transparent, CircleShape)
            )
            Spacer(
                modifier = Modifier.width(16.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = pet.name,
                        style = MaterialTheme.typography.h5
                    )
                    Icon(
                        imageVector = iconVector,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
                Row(
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(text = "Breed: ${pet.breed}", style = MaterialTheme.typography.body1)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Age: ${pet.age} months", style = MaterialTheme.typography.body1)
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                FavButton()
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PetTheme {
        PetItem(
            pet = Pet(
                id = 0,
                name = "Max",
                gender = Gender.Male,
                origin = "",
                age = 1,
                breed = "Boxer",
                energyLevel = "High",
                size = "Large"
            ),
            selectPet = { }
        )
    }
}
