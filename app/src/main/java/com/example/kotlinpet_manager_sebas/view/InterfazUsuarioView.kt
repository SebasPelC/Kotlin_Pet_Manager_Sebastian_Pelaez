package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.kotlinpet_manager_sebas.navigation.ItemsMenu
import com.example.kotlinpet_manager_sebas.viewmodel.PacienteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuarioView(
    viewModel: PacienteViewModel = viewModel()
) {
    val navController = rememberNavController()


    val navegacionItems = listOf(
        ItemsMenu.Registro,
        ItemsMenu.Lista
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("KotlinPet Manager 🐾") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val rutaActual = navBackStackEntry?.destination?.route

                navegacionItems.forEach { item ->
                    NavigationBarItem(
                        selected = rutaActual == item.ruta,
                        onClick = {
                            navController.navigate(item.ruta) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(imageVector = item.icono, contentDescription = item.titulo) },
                        label = { Text(item.titulo) }
                    )
                }
            }
        }
    ) { padding ->
        // Aquí se inyectan las pantallas dependiendo de la ruta
        NavHost(
            navController = navController,
            startDestination = ItemsMenu.Registro.ruta,
            modifier = Modifier.padding(padding)
        ) {
            composable(ItemsMenu.Registro.ruta) {
                PantallaRegistroView(viewModel = viewModel)
            }
            composable(ItemsMenu.Lista.ruta) {
                ListaPacientesView(viewModel = viewModel)
            }
        }
    }
}

