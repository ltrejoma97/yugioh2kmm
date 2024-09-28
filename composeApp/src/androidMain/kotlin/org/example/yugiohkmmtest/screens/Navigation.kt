package org.example.yugiohkmmtest.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import moe.tlaster.precompose.viewmodel.viewModel
import org.example.yugiohkmmtest.viewModel.ListScreenViewModel
import org.example.yugiohkmmtest.viewModel.MainViewModel

@Composable
fun Navigation(vm: MainViewModel, detailVm: ListScreenViewModel) {
    val navController = rememberNavController()



    NavHost(navController = navController, startDestination = "home"  ){
        composable("home"){
            MainScreen(
                onCardClick = { yugiohCard ->
                    navController.navigate("detail/${yugiohCard.id}")
                },
                vm = vm)
        }

        composable(
            route ="detail/{cardId}",
            arguments = listOf(navArgument("cardId") { type = NavType.IntType })
        ){backstackEntry ->
            val cardId = checkNotNull(backstackEntry.arguments?.getInt("cardId"))
            DetailScreen(
                vm = detailVm,
                onBack = { navController.popBackStack() },
            )
        }
    }
}