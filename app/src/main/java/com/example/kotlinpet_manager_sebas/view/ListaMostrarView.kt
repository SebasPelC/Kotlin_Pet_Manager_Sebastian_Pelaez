package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlinpet_manager_sebas.model.Paciente

@Composable
fun ListaMostrarView(pacientes: List<Paciente>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(pacientes) { paciente ->
            // Cada paciente se muestra dentro de un contenedor ElevatedCard
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = paciente.nombre,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "ID: ${paciente.id} | Especie: ${paciente.especie}", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Edad: ${paciente.edad} años | Contacto: ${paciente.contacto}", style = MaterialTheme.typography.bodyMedium)
                    }

                    // Alerta visual de urgencia
                    if (paciente.esUrgencia) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Urgencia",
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }
            }
        }
    }
}