package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    var contacto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // para pantallas pequeñas
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InterfazTextoInput(
            value = id,
            onValueChange = { id = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese el id del peludito"
        )
        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese nombre del peludito"
        )
        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = especie,
            onValueChange = { especie = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese la especie del peludito"
        )
        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = edad,
            onValueChange = { edad = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese la edad del peludito"
        )
        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = esUrgencia,
            onValueChange = { esUrgencia = it },
            modifier = Modifier.fillMaxWidth(),
            label = "¿El paciente tiene una urgencia?"
        )
        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = contacto,
            onValueChange = { contacto = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Contacto de emergencia del peludito"
        )
        Spacer(modifier = Modifier.height(16.dp))

        InterfazFilaView(
            limpiarUsuarios = {
                id = ""
                nombre = ""
                especie = ""
                edad = ""
                esUrgencia = ""
                contacto = ""
            },
            botonAgregarPaciente = {
                resultado = "Paciente guardado exitosamente:\nId: $id \nNombre: $nombre \nEspecie: $especie \nEdad: $edad \n¿Es una Urgencia?: $esUrgencia \nNumero de Contacto: $contacto"

                viewModel.agregarPaciente(
                    id = id,
                    nombre = nombre,
                    especie = especie,
                    edad = edad,
                    esUrgencia = esUrgencia,
                    contacto = contacto
                )

                id = ""; nombre = ""; especie = ""; edad = ""; esUrgencia = ""; contacto = ""
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (resultado.isNotEmpty()) {
            InterfazTextoView(texto = resultado, estilo = MaterialTheme.typography.bodyLarge)
        }
    }
}