package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinpet_manager_sebas.model.Paciente

@Composable
fun ListaMostrarView(pacientes: List<Paciente>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pacientes) { paciente ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "ID: ${paciente.id}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Nombre: ${paciente.nombre}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Especie: ${paciente.especie}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Edad: ${paciente.edad}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Urgencia: ${if (paciente.esUrgencia) "Sí" else "No"}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}