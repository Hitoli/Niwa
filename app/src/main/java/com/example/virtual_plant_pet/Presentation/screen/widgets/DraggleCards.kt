package com.example.virtual_plant_pet.Presentation.screen.widgets

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.virtual_plant_pet.R
import kotlin.math.roundToInt

@Composable
fun DraggableCards(cardImage:Int,cardValue:Int,sizeWidth:Dp,sizeHeight:Dp,offsetXdrag:Int,offsetYdrag:Int,dragging:Boolean,InitialPositionx:Int,InitialPositiony:Int,modifier:Modifier=Modifier,onDrag:(Boolean)->Unit,onOffsetX:(Int)->Unit,onOffsetY:(Int)->Unit) {
    Image(
        painter = painterResource(id = R.drawable.niwaplayingcard),
        contentDescription = "image description",
        contentScale = ContentScale.FillBounds, modifier = Modifier
            .width(sizeWidth)
            .height(sizeHeight)
            .offset { IntOffset(offsetXdrag, offsetYdrag) } .pointerInput(Unit) {
                detectDragGestures(onDrag = { change, dragAmount ->
                    onDrag(true)
                    onOffsetX( dragAmount.x.roundToInt())
                    onOffsetY( dragAmount.y.roundToInt())
                }, onDragEnd = {
                    onDrag(false)
                })
            }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDraggableCards() {
    DraggableCards()
}