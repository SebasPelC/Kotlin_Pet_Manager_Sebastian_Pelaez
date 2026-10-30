package com.example.kotlinpet_manager_sebas.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ItemsMenu(
    val ruta: String,
    val titulo: String,
    val icono: ImageVector
){
    // Pestaña 1: Para el formulario de registro
    object Registro : ItemsMenu("registro", "Registrar", Icons.Default.Add)

    // Pestaña 2: Para la lista dinámica de pacientes
    object Lista : ItemsMenu("lista", "Pacientes", Icons.AutoMirrored.Filled.List)
}