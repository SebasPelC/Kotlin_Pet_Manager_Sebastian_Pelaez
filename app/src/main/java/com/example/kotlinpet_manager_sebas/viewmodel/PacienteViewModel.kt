package com.example.kotlinpet_manager_sebas.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinpet_manager_sebas.model.Paciente
import kotlin.collections.emptyList

class PacienteViewModel: ViewModel() {
    var pacientes by mutableStateOf<List<Paciente>>(emptyList())
        private set

    init {

    }

    fun agregarPaciente(
        id: String,
        nombre: String,
        especie: String,
        edad: String,
        esUrgencia: String
    ){
        // Validaciones básicas o conversiones seguras de tipos
        val edad = edad.toIntOrNull() ?: 0
        // evaluar si el texto dice "sí", "true", etc., o pasarlo a Boolean
        val esUrgencia = esUrgencia.equals("si", ignoreCase = true) || esUrgencia.equals("true", ignoreCase = true)

        //  nuevo objeto Paciente
        val nuevoPaciente = Paciente(
            id = id,
            nombre = nombre,
            especie = especie,
            edad = edad,
            esUrgencia = esUrgencia
        )

        // Actualizamos la lista agregando el nuevo paciente al final (o al inicio)
        pacientes = pacientes + nuevoPaciente
    }


    fun limpiarUsuarios(){
        pacientes = emptyList()
    }
}



