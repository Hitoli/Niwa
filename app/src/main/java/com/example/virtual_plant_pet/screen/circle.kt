package com.example.solus.authScreens.authUtils

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyCircle(size:Int,color: Color){
    Canvas(modifier = Modifier.size(size.dp), onDraw = {
        drawCircle(color = color, center = center.copy(y = -5f))
    })
}