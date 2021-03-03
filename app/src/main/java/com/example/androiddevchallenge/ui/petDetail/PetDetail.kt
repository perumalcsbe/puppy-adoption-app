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
package com.example.androiddevchallenge.ui.petDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.repository.PetRepository
import com.example.androiddevchallenge.ui.common.FeatureCard
import com.example.androiddevchallenge.ui.theme.Lavender2
import com.example.androiddevchallenge.ui.theme.Neutral8
import com.example.androiddevchallenge.ui.theme.PetTheme
import com.example.androiddevchallenge.ui.theme.Shadow3
import com.example.androiddevchallenge.ui.utils.NetworkImage
import com.example.androiddevchallenge.ui.utils.horizontalGradientBackground
import dev.chrisbanes.accompanist.insets.statusBarsPadding

private val headerHeight = 280.dp
@Composable
fun PetDetail(
    petId: Long,
    upPress: () -> Unit
) {
    val pet = remember(petId) { PetRepository.getPet(petId) }
    PetTheme {

        LazyColumn {
            item {
                Box(Modifier.fillMaxSize()) {
                    PetDetailHeader()
                    PetDetailImage(pet.image)
                    BackButton(upPress = upPress)
                }
            }
            item {
                PetDetailTitle(pet)
            }
            item {
                Body(pet = pet)
            }
            item {
                Footer(pet = pet)
            }
        }
    }
}

@Composable
fun Footer(pet: Pet) {
    val gender = if (pet.gender == Gender.Male) "Male" else "Female"
    Column(
        Modifier.padding(horizontal = 24.dp)
    ) {

        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            FeatureCard(sectionText = "Age", valueText = "${pet.age} months")
            FeatureCard(sectionText = "Breed", valueText = pet.breed)
            FeatureCard(sectionText = "Energy Level", valueText = pet.energyLevel)
        }
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FeatureCard(sectionText = "Size", valueText = pet.size)
            FeatureCard(sectionText = "Gender", valueText = gender)
        }

        // Button not working????
        Card(
            modifier = Modifier
                .height(50.dp)
                .padding(6.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Adopt Me",
                    color = White,
                    modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally).padding(6.dp),
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Composable
fun PetDetailImage(
    imageUrl: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(headerHeight)
    ) {
        NetworkImage(
            url = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun PetDetailHeader() {
    Spacer(
        modifier = Modifier
            .height(headerHeight)
            .fillMaxWidth()
            .horizontalGradientBackground(listOf(Lavender2, Shadow3))
    )
}

@Composable
fun PetDetailTitle(pet: Pet) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = 56.dp)
            .statusBarsPadding()
            .background(color = White)
    ) {
        Text(
            text = pet.name,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}

@Composable
fun Body(pet: Pet) {
    Column {
        Row {
            FavButton()
            Text(
                text = pet.details,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(4.dp))
        }
    }
}

@Composable
private fun BackButton(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Neutral8.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = "back"
        )
    }
}

@Composable
fun FavButton() {
    IconButton(
        onClick = { },
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Neutral8.copy(alpha = 0.32f),
                shape = CircleShape
            ),

    ) {
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = "back"
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PetTheme {
        PetDetail(
            petId = 0,
            upPress = { }
        )
    }
}
