package org.example.yugiohkmmtest.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import moe.tlaster.precompose.PreComposeApp
import org.example.yugiohkmmtest.viewModel.CardsUiState
import org.example.yugiohkmmtest.viewModel.ListScreenUIState
import org.example.yugiohkmmtest.viewModel.ListScreenViewModel


@Composable
fun MainScreen(listState: ListScreenUIState) {
    PreComposeApp {
        val navItemList = listOf(
            NavItem(label = "List", icon = Icons.Default.List),
            NavItem(label = "Map", icon = Icons.Default.LocationOn),
            NavItem(label = "Hello", icon = Icons.Default.Person)
        )
//Almacenar el indice de la barra de navegación. iniciando en 0 "List"
        var selectedIndex by remember { mutableStateOf(0) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                NavigationBar {
                    navItemList.forEachIndexed { index, navItem ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            icon = {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = "icon"
                                )
                            },
                            label = { Text(text = navItem.label) }
                        )
                    }
                }

            }) { innerPadding ->
            ContentScreen(modifier = Modifier.padding(innerPadding),
                selectedIndex, listState)
        }
    }
}


@Composable
fun ContentScreen(
    modifier: Modifier,
    selectedIndex: Int,
    listState: ListScreenUIState

) {
    when (selectedIndex) {
        0 ->{
            Log.d("MainScreen", "ListState: ${listState.responseCards}")
            ListScreenState(listState)}
        1 -> ShowingMap()
        2 -> Hello()
    }
}

data class NavItem(val label: String, val icon: ImageVector)