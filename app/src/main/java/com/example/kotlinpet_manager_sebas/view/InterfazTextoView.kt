package com.example.kotlinpet_manager_sebas.view

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun InterfazTextoView(
    texto: String,
    estilo: TextStyle = MaterialTheme.typography.bodyMedium
){
    Text(
        text = texto,
        style = estilo
    )
}