package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InterfazFilaView(
    limpiarFormulario: () -> Unit,
    botonAgregarPaciente: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(onClick = limpiarFormulario) {
            Text("Limpiar")
        }


        Button(onClick = botonAgregarPaciente) {
            Text("Registrar Paciente")
        }
    }
}

