package com.example.androiddevchallenge

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import androidx.navigation.compose.*
import com.example.androiddevchallenge.ui.utils.Navigator
import kotlinx.parcelize.Parcelize

/**
 * FIXME: NOT WORKING
 *
@Composable
fun NavGraph(startDestination: String = Destinations.Home) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.Home) {
            Home(
                selectPet = actions.selectPet
            )
        }
        composable(
            "$PetDetail/$PET_ID_KEY",
            arguments = listOf(navArgument(PET_ID_KEY) { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            PetDetail(
                petId = arguments.getLong(PET_ID_KEY),
                upPress = actions.upPress
            )
        }
    }
}

object Destinations {
    const val Home = "home"
    const val PetDetail = "petDetail"
    const val PET_ID_KEY = "petId"
}


class Actions(navController: NavHostController) {
    val selectPet: (Long) -> Unit = { petId: Long ->
        navController.navigate("$PetDetail/$petId")
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
*/
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