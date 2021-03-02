package com.example.androiddevchallenge

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.androiddevchallenge.ui.home.Home
import com.example.androiddevchallenge.ui.petDetail.PetDetail
import com.example.androiddevchallenge.ui.utils.LocalBackDispatcher
import com.example.androiddevchallenge.ui.utils.Navigator
import com.example.androiddevchallenge.ui.utils.ProvideImageLoader
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun PetAdaptionApp(
    backPressedDispatcher: OnBackPressedDispatcher
) {
    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backPressedDispatcher)
    ) {
        Navigator(Destination.Home, backPressedDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }
    CompositionLocalProvider(LocalBackDispatcher provides backPressedDispatcher) {
        ProvideWindowInsets {
            ProvideImageLoader {
                //NavGraph()
                Crossfade(navigator.current) { destination ->
                    when (destination) {
                        Destination.Home -> Home(actions.selectPet)
                        is Destination.PetDetail -> PetDetail(
                            petId = destination.petId,
                            upPress = actions.upPress
                        )
                    }
                }
            }
        }
    }
}

