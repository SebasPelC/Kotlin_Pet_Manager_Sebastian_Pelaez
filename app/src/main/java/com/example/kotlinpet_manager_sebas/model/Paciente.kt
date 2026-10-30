package com.example.kotlinpet_manager_sebas.model

data class Paciente(
    val id: String = "",
    val nombre: String = "",
    val especie: String = "",
    val edad: Int = 0 ,
    val esUrgencia: Boolean = false
)