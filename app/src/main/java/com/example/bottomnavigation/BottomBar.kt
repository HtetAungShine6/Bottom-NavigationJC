package com.example.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
    val route : String,
    val title : String,
    val icon : ImageVector
) {

    object Reporting : BottomBar(
        route = "reporting",
        title = "Reporting",
        icon = Icons.Default.Person
    )

    object Home : BottomBar(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Setting : BottomBar(
        route = "setting",
        title = "Setting",
        icon = Icons.Default.Settings
    )
}