package com.example.kotlinpet_manager_sebas.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinpet_manager_sebas.viewmodel.PacienteViewModel
import androidx.compose.foundation.lazy.items

@Composable

fun InterfazColumnView(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: PacienteViewModel = viewModel()
){
    var id by remember {mutableStateOf("")}
    var nombre by remember {mutableStateOf("")}
    var especie by remember {mutableStateOf("")}
    var edad by remember {mutableStateOf("")}
    var esUrgencia by remember {mutableStateOf("")}
    var resultado by remember{mutableStateOf("")}


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        //InterfazTextoView(texto = "Hola mundo desde interfaz text")

        InterfazTextoInput(
            value = id,
            onValueChange = {id = it},
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese el id del peludito" )

        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = nombre,
            onValueChange = {nombre = it},
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese nombre del peludito" )

        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = especie,
            onValueChange = {especie = it},
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese la especie del peludito" )

        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = edad,
            onValueChange = {edad = it},
            modifier = Modifier.fillMaxWidth(),
            label = "Ingrese la edad del usuario" )

        Spacer(modifier = Modifier.height(16.dp))

        InterfazTextoInput(
            value = esUrgencia,
            onValueChange = {esUrgencia = it},
            modifier = Modifier.fillMaxWidth(),
            label = "¿El paciente tiene una urgencia?" )

        Spacer(modifier = Modifier.height(16.dp))

        InterfazFilaView(
            limpiarUsuarios= {
                id = ""
                nombre = ""
                especie = ""
                edad = ""
                esUrgencia = ""

            },
            botonAgregarPaciente = {

                resultado = "Paciente guardado exitosamente :\n Id: $id \nNombre: $nombre \nEspeci: $especie \n Edad: $edad \n ¿Es una urgencia?: $esUrgencia"

                viewModel.agregarPaciente(
                    id = id,
                    nombre = nombre,
                    especie = especie,
                    edad = edad,
                    esUrgencia = esUrgencia
                )

                id = ""
                nombre = ""
                especie = ""
                edad = ""
                esUrgencia = ""


            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        if(resultado.isNotEmpty()){
            InterfazTextoView(texto = resultado, estilo= MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.height(16.dp))

        ListaMostrarView(pacientes = viewModel.pacientes)



    }

}

