package com.example.kotlinpet_manager_sebas.view


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun InterfazUsuarioView(){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("KotlinPet Manager")

            })
        }
    ) { padding ->
        InterfazColumnView(paddingValues = padding)


    }
}

