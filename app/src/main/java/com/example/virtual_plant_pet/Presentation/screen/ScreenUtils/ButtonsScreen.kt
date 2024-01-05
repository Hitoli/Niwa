package com.example.virtual_plant_pet.Presentation.screen.ScreenUtils

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundBlackShade

@Preview(showBackground = true)
@Composable
fun ButtonPrecview() {
    ButtonScreen("Login", onClick = {},60.dp,300.dp)
}

@Composable
fun ButtonScreen(value: String,onClick:()->Unit,height:Dp,width:Dp) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .heightIn(height)
            .widthIn(width),
        colors = ButtonDefaults.buttonColors(virtual_plant_backgroundBlackShade),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = value, fontSize = 14.sp, color = Color.White, fontFamily = fontFamily)
    }
}