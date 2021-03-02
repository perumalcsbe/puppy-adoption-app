package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Eco
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.*
import com.example.androiddevchallenge.ui.theme.PetTheme
import com.example.androiddevchallenge.ui.utils.NetworkImage
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun PetList(
    pets: List<Pet>,
    selectPet: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        item {
            Spacer(Modifier.statusBarsHeight())
        }
        item {
            PetAdaptionAppBar()
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        itemsIndexed(pets) { index, pet ->
            PetItem(pet, index, selectPet)
        }
    }
}

@Composable
fun PetItem(pet: Pet, index: Int, selectPet: (Long) -> Unit) {
    val iconVector =  if (pet.gender == Gender.Male) Icons.Rounded.Male else Icons.Rounded.Female

    Row(modifier = Modifier.padding(bottom = 8.dp).clickable(onClick = { selectPet(pet.id) })) {
            if (index % 2 == 0) {
                NetworkImage(
                    url = pet.image,
                    contentDescription = "Pet image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape) //RoundedCornerShape(percent - 10)
                        .border(2.dp, Color.Transparent, CircleShape)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(10.dp)).background(Color.LightGray)
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                ) {


                    Text(
                        text = pet.name,
                        style = MaterialTheme.typography.h4
                    )
                    Text(
                        text = "Breed: ${pet.breed}",
                        style = MaterialTheme.typography.caption
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = iconVector,
                            tint = MaterialTheme.colors.primary,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            if (index % 2 != 0) {
                NetworkImage(
                    url = pet.image,
                    contentDescription = "Pet image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .requiredSize(100.dp)
                        .clip(RoundedCornerShape(percent = 10))
                        .border(2.dp, Color.Transparent, CircleShape)
                )
            }
        }

}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PetTheme {
        PetItem(pet = Pet(
                id = 0,
            name = "Max",
            gender = Gender.Male,
            origin = "",
            age = 1,
            breed = Breed.Boxer,
            energyLevel = EnergyLevel.High,
            size = Size.Large
        ),
            index = 0,
            selectPet = { }
        )
    }
}