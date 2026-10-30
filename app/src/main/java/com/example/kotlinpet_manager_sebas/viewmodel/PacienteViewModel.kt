package com.example.kotlinpet_manager_sebas.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinpet_manager_sebas.model.Paciente

class PacienteViewModel: ViewModel() {
    var pacientes by mutableStateOf<List<Paciente>>(emptyList())
        private set

    // Cambiamos a que retorne Boolean para informar a la interfaz del resultado
    fun agregarPaciente(
        id: String,
        nombre: String,
        especie: String,
        edad: String,
        esUrgencia: String,
        contacto: String
    ): Boolean {
        val idL = id.trim()
        val nombreL = nombre.trim()
        val especieL = especie.trim()
        val edadL = edad.trim()
        val urgenciaL = esUrgencia.trim()
        val contactoL = contacto.trim()

        // 1. Bloquear campos vacíos
        if (idL.isEmpty() || nombreL.isEmpty() || especieL.isEmpty() || edadL.isEmpty() || contactoL.isEmpty()) {
            return false
        }

        // 2. Bloquear números en el nombre y la especie
        if (nombreL.any { it.isDigit() } || especieL.any { it.isDigit() }) {
            return false
        }

        // 3. Validar tipo estricto para edad (solo números enteros positivos)
        val edadInt = edadL.toIntOrNull()
        if (edadInt == null || edadInt < 0) {
            return false
        }

        // 4. Restringir la urgencia a palabras lógicas (bloquea números o textos sin sentido)
        val opcionesUrgencia = listOf("si", "sí", "no", "true", "false")
        if (urgenciaL.lowercase() !in opcionesUrgencia) {
            return false
        }
        val esUrgenciaBool = urgenciaL.equals("si", ignoreCase = true) ||
                urgenciaL.equals("sí", ignoreCase = true) ||
                urgenciaL.equals("true", ignoreCase = true)

        // 5. Crear e insertar el registro validado
        val nuevoPaciente = Paciente(
            id = idL,
            nombre = nombreL,
            especie = especieL,
            edad = edadInt,
            esUrgencia = esUrgenciaBool,
            contacto = contactoL
        )

        pacientes = pacientes + nuevoPaciente
        return true
    }

    fun limpiarFormulario(){

    }
}



