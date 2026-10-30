package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.kotlinpet_manager_sebas.viewmodel.PacienteViewModel

@Composable
fun PantallaRegistroView(
    modifier: Modifier = Modifier,
    viewModel: PacienteViewModel
) {
    var id by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var especie by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var esUrgencia by remember { mutableStateOf("") }
    var contactoEmergencia by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    // El contenedor Column es un requisito directo para el formulario[cite: 6]
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InterfazTextoInputView(
            value = id,
            onValueChange = { id = it },
            label = "ID del peludito",
            modifier = Modifier.fillMaxWidth(),
            icono = Icons.Default.Numbers
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Campos requeridos por la rúbrica: Nombre, Especie/Raza, Edad y Contacto de emergencia[cite: 6]
        InterfazTextoInputView(
            value = nombre,
            onValueChange = { nombre = it },
            label = "Nombre",
            modifier = Modifier.fillMaxWidth(),
            icono = Icons.Default.Face
        )
        Spacer(modifier = Modifier.height(12.dp))

        InterfazTextoInputView(
            value = especie,
            onValueChange = { especie = it },
            label = "Especie/Raza",
            modifier = Modifier.fillMaxWidth(),
            icono = Icons.Default.Info
        )
        Spacer(modifier = Modifier.height(12.dp))

        InterfazTextoInputView(
            value = edad,
            onValueChange = { edad = it },
            label = "Edad (Años)",
            modifier = Modifier.fillMaxWidth(),
            icono = Icons.Default.DateRange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(12.dp))

        InterfazTextoInputView(
            value = esUrgencia,
            onValueChange = { esUrgencia = it },
            label = "¿Es urgencia? (Si/No)",
            modifier = Modifier.fillMaxWidth(),
            icono = Icons.Default.Warning
        )
        Spacer(modifier = Modifier.height(12.dp))

        InterfazTextoInputView(
            value = contactoEmergencia,
            onValueChange = { contactoEmergencia = it },
            label = "Contacto de emergencia",
            modifier = Modifier.fillMaxWidth(),
            icono = Icons.Default.Phone,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.height(24.dp))

        InterfazFilaView(
            limpiarFormulario = {
                id = ""; nombre = ""; especie = ""; edad = ""; esUrgencia = ""; contactoEmergencia = ""; resultado = ""
            },
            botonAgregarPaciente = {
                val guardadoExitoso = viewModel.agregarPaciente(id, nombre, especie, edad, esUrgencia, contactoEmergencia)
                if (guardadoExitoso) {
                    resultado = "Paciente guardado exitosamente:\nId: $id \nNombre: $nombre \nEspecie: $especie \nEdad: $edad \nUrgencia: $esUrgencia \nContacto: $contactoEmergencia"
                    id = ""; nombre = ""; especie = ""; edad = ""; esUrgencia = ""; contactoEmergencia = ""
                } else {
                    resultado = "Error: Verifica que no haya campos vacíos y que los datos sean válidos."
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                style = MaterialTheme.typography.bodyLarge,
                color = if (resultado.startsWith("Error")) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
            )
        }
    }
}