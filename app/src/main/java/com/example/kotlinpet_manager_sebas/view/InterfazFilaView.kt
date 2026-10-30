package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ButtonDefaults
@Composable

fun InterfazFilaView(
    limpiarUsuarios: () -> Unit,
    botonAgregarPaciente: () -> Unit
){
    Row(
        modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(
            onClick = limpiarUsuarios,
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onSecondary,
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(text = "Limpiar Usuarios")
        }
        Button(
            onClick = botonAgregarPaciente,
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = "Agregar Paciente")
        }

    }

}

