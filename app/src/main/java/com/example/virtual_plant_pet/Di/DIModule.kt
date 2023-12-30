package com.example.virtual_plant_pet.Di

import com.example.virtual_plant_pet.Presentation.screen.ViewModels.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DIModule = module {
    viewModel { AuthViewModel() }
}