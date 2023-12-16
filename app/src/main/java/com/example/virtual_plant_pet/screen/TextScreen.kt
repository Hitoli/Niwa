package com.example.virtual_plant_pet.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.virtual_plant_pet.ui.theme.fontFamily


@Composable
fun TextScreen(value:String, font:Int) {
    Text(text = value, fontSize = font.sp, color = Color.Black, fontFamily = fontFamily)
}