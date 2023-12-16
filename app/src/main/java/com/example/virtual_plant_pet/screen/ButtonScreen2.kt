package com.example.virtual_plant_pet.screen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtual_plant_pet.ui.theme.fontFamily


@Preview(showBackground = true)
@Composable
fun ButtonPreview2() {
    ButtonScreen2("Sign Up", onClick = {})
}


@Composable
fun ButtonScreen2(value:String, onClick:()->Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .heightIn(60.dp)
            .widthIn(300.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(text = value, fontSize = 14.sp, color = Color.Black, fontFamily = fontFamily)
    }
}