package com.example.virtual_plant_pet.utils

import android.util.LayoutDirection

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import kotlin.math.ceil
import kotlin.random.Random

class WavyShape(
    private val period: Dp,
    private val amplitude: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: androidx.compose.ui.unit.LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val wavyPath = Path().apply {
            val halfPeriod = with(density) { period.toPx() }
            val amplitude = with(density) { amplitude.toPx() }/8
            moveTo(x = -halfPeriod / 2, y = amplitude)
            repeat(ceil(size.width / halfPeriod + 1).toInt()) { i ->
                relativeQuadraticBezierTo(
                    dx1 = halfPeriod / 2,
                    dy1 = 2 * amplitude * (if (i % 2 == 0) Random.nextInt(1, 4) else -1),
                    dx2 = halfPeriod,
                    dy2 = 0f,
                )
            }
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
        }
        val boundsPath = Path().apply {
            addRect(Rect(offset = Offset.Zero, size = size))
        }
        op(wavyPath, boundsPath, PathOperation.Intersect)
    })
}