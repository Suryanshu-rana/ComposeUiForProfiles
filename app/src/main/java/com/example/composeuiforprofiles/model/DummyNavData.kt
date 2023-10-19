package com.example.composeuiforprofiles.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings

object DummyNavData {
    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Default.Home,
            selected = false
        ),
        BottomNavItem(
            name = "Create",
            route = "add",
            icon = Icons.Default.AccountCircle,
            selected = false
        ),
        BottomNavItem(
            name = "Settings",
            route = "settings",
            icon = Icons.Default.Settings,
            selected = false
        ),
    )
}