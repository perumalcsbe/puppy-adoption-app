package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.PetTheme
import com.example.androiddevchallenge.viewmodel.PetViewModel
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun Home(
    selectPet: (Long) -> Unit
) {
    val viewModel = PetViewModel()
    PetTheme {
        PetList(pets = viewModel.pets, selectPet = selectPet)
    }
}

@Composable
fun PetAdaptionAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.height(80.dp)
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Pet Adoption",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "profile"
            )
        }
    }
}

/*
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Ready... Set... GO!")
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
*/
