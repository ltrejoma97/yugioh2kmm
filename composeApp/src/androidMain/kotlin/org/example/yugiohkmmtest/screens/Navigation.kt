package org.example.yugiohkmmtest.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.example.yugiohkmmtest.viewModel.MainViewModel

@Composable
fun Navigation(vm: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"  ){
        composable("home"){
            MainScreen(
                onCardClick = { yugiohCard ->
                    val json = Json { ignoreUnknownKeys = true }
                    val jsonEncode = json.encodeToJsonElement(yugiohCard).toString()
                    val encodedName = encodeUrlComponent(yugiohCard.name)
                    val encodedImageUrl = encodeUrlComponent(yugiohCard.imgUrl)

                    navController.navigate("detail/${yugiohCard.id}/$encodedName/$encodedImageUrl")
                },
                vm = vm)
        }

        composable(
            route = "detail/{movieId}/{cardName}/{cardImages}",
            arguments = listOf(
                navArgument("movieId") { type = NavType.IntType },
                navArgument("cardName") { type = NavType.StringType },
                navArgument("cardImages") { type = NavType.StringType },
            )
        ) { backstackEntry ->
            val movieId = checkNotNull(backstackEntry.arguments?.getInt("movieId"))
            val cardName = checkNotNull(backstackEntry.arguments?.getString("cardName"))
            val cardImages = checkNotNull(backstackEntry.arguments?.getString("cardImages"))
            DetailScreen(
                cardId = movieId,
                cardName = cardName,
                cardImages = cardImages,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

fun encodeUrlComponent(value: String): String {
    return value.replace(" ", "%20")
        .replace("!", "%21")
        .replace("#", "%23")
        .replace("$", "%24")
        .replace("&", "%26")
        .replace("'", "%27")
        .replace("(", "%28")
        .replace(")", "%29")
        .replace("*", "%2A")
        .replace("+", "%2B")
        .replace(",", "%2C")
        .replace("/", "%2F")
        .replace(":", "%3A")
        .replace(";", "%3B")
        .replace("=", "%3D")
        .replace("?", "%3F")
        .replace("@", "%40")
        .replace("[", "%5B")
        .replace("]", "%5D")
}