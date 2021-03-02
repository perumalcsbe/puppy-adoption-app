package com.example.androiddevchallenge.ui.petDetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.repository.PetRepository
import com.example.androiddevchallenge.ui.theme.Neutral8
import com.example.androiddevchallenge.ui.theme.Ocean3
import com.example.androiddevchallenge.ui.theme.PetTheme
import com.example.androiddevchallenge.ui.theme.Shadow3
import com.example.androiddevchallenge.ui.utils.horizontalGradientBackground
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun PetDetail(
    petId: Long,
    upPress: () -> Unit
) {
    val pet = remember(petId) { PetRepository.getPet(petId) }
    PetTheme {
        Box(Modifier.fillMaxSize()) {
            val scroll = rememberScrollState(0)
            PetDetailHeader()
            Body(scroll = scroll, pet = pet)
            PetDetailTitle(pet, scroll.value)
            PetDetailImage()
            BackButton(upPress = upPress)
            Footer()
        }
    }
}

@Composable
fun Footer() {
    TODO("Not yet implemented")
}

@Composable
fun PetDetailImage() {
    TODO("Not yet implemented")
}

@Composable
fun PetDetailHeader() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .horizontalGradientBackground(listOf(Ocean3, Shadow3))
    )
}

@Composable
fun PetDetailTitle(pet: Pet, scroll: Int) {
    val maxOffset = with(LocalDensity.current) { 360.dp.toPx() }
    val minOffset = with(LocalDensity.current) { 56.dp.toPx() }
    val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = 56.dp)
            .statusBarsPadding()
            .graphicsLayer { translationY = offset }
            .background(color = LightGray)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = pet.name,
            style = MaterialTheme.typography.h4,
           // color = JetsnackTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}

@Composable
fun Body(scroll: ScrollState, pet: Pet) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(56.dp)
        )

        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(200.dp))

            Surface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(260.dp))
                    Text(
                        text = pet.name,
                        style = MaterialTheme.typography.overline,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = pet.details,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = "${pet.age} months",
                        style = MaterialTheme.typography.overline,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                }
            }
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
           // tint = PetTheme.colors.iconInteractive,
            contentDescription = "back"
        )
    }
}

@Composable
fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
           // .background(Brush.horizontalGradient(PetTheme.colors.interactivePrimary))
    )
}


