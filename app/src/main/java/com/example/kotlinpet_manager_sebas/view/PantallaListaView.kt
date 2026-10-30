package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinpet_manager_sebas.viewmodel.PacienteViewModel

@Composable
fun ListaPacientesView(
    modifier: Modifier = Modifier,
    viewModel: PacienteViewModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ListaMostrarView(pacientes = viewModel.pacientes)
    }
}