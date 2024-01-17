package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.virtual_plant_pet.R
import kotlin.math.roundToInt

@Preview(showBackground = true)
@Composable
fun TestScreen() {
    val config = LocalConfiguration.current
    val screenHeight = config.screenHeightDp.dp
    val screenWidth = config.screenWidthDp.dp
    val density = LocalDensity.current

    var alignment by remember {
        mutableStateOf(Alignment.BottomCenter)
    }

    val widthinPX = with(density) { screenWidth.roundToPx() }
    val heightinPX = with(density) { screenHeight.roundToPx() }

    var dragItemPosition by remember {
        mutableStateOf(Offset.Zero)
    }
    var contains by remember {
        mutableStateOf(false)
    }

    var offsetx by remember {
        mutableStateOf((screenWidth.value+30).toInt())
    }
    var offsety by remember {
        mutableStateOf((screenHeight.value*2-150).toInt())
    }
    var offsetx2 by remember {
        mutableStateOf((screenWidth.value-250).toInt())
    }
    var offsety2 by remember {
        mutableStateOf((screenHeight.value*2-150).toInt())
    }
    var sizeWidth1 by remember {
        mutableStateOf(87.dp)
    }
    var sizeHeight1 by remember {
        mutableStateOf(127.dp)
    }
    var InitialPositionx by remember {
        mutableStateOf(0)
    }
    var InitialPositiony by remember {
        mutableStateOf(0)
    }

    var dragging by remember {
        mutableStateOf(true)
    }
    val draganime = remember {
        SpringSpec<Int>(stiffness = Spring.StiffnessHigh, visibilityThreshold = 1)
    }
    val dropanime = remember {
        SpringSpec<Int>(stiffness = Spring.StiffnessLow, visibilityThreshold = 1)
    }
    val animespec = if (dragging) draganime else dropanime

    var offsetXdrag = animateIntAsState(
        targetValue = offsetx, animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag = animateIntAsState(
        targetValue = offsety, animationSpec = animespec,
        label = "Animation on offset Y"
    )

    var offsetXdrag2 = animateIntAsState(
        targetValue = offsetx2, animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag2 = animateIntAsState(
        targetValue = offsety2, animationSpec = animespec,
        label = "Animation on offset Y"
    )



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(1.dp)
                .width(138.dp)
                .height(204.dp)
                .background(color = Color(0x4D000000), shape = RoundedCornerShape(10.dp))
                .onGloballyPositioned { layoutCoordinates ->
                    layoutCoordinates
                        .positionInWindow()
                        .apply {
                            InitialPositionx = this.x.roundToInt()
                            InitialPositiony = this.y.roundToInt()

                        }
                }
        )
        Image(
            painter = painterResource(id = R.drawable.niwaplayingcard),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds, modifier = Modifier
                .width(sizeWidth1)
                .height(sizeHeight1)

//                            .offset(y = -60.dp)
                .offset { IntOffset(offsetXdrag.value, offsetYdrag.value) }
                .onGloballyPositioned {
                    dragItemPosition = it.localToWindow(Offset.Zero)


                }
                .pointerInput(Unit) {
                    detectDragGestures(onDrag = { change, dragAmount ->
                        change.consume()
                        sizeWidth1 = 127.dp
                        sizeHeight1 = 187.dp
                        dragging = true
                        Log.e("dragginf", change.pressed.toString())
                        offsetx += dragAmount.x.roundToInt()
                        offsety += dragAmount.y.roundToInt()
                    }, onDragEnd = {
                        dragItemPosition = Offset.Zero
                        offsetx = InitialPositionx
                        offsety = InitialPositiony
                        Log.e("Contains IntialPostion", InitialPositionx.toString())
                        Log.e("Contains IntialPostion", InitialPositiony.toString())
                        Log.e("Contains offsetx", offsetx.toString())
                        Log.e("Contains offsety", offsety.toString())

                    }, onDragStart = {
                        dragItemPosition += it
                    }, onDragCancel = {
                        dragItemPosition = Offset.Zero
                        dragging = false
                    })


                }
        )
        Image(
            painter = painterResource(id = R.drawable.niwaplayingcard),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds, modifier = Modifier
                .width(sizeWidth1)
                .height(sizeHeight1)
                .offset { IntOffset(offsetXdrag2.value, offsetYdrag2.value) }
                .onGloballyPositioned {
                    dragItemPosition = it.localToWindow(Offset.Zero)
                }
                .pointerInput(Unit) {
                    detectDragGestures(onDrag = { change, dragAmount ->
                        change.consume()
                        sizeWidth1 = 127.dp
                        sizeHeight1 = 187.dp
                        dragging = true
                        Log.e("dragginf", change.pressed.toString())
                        offsetx2 += dragAmount.x.roundToInt()
                        offsety2 += dragAmount.y.roundToInt()
                    }, onDragEnd = {
                        dragItemPosition = Offset.Zero
                        offsetx2 = InitialPositionx
                        offsety2 = InitialPositiony
                        Log.e("Contains IntialPostion", InitialPositionx.toString())
                        Log.e("Contains IntialPostion", InitialPositiony.toString())
                        Log.e("Contains offsetx", offsetx2.toString())
                        Log.e("Contains offsety", offsety2.toString())

                    }, onDragStart = {
                        dragItemPosition += it
                    }, onDragCancel = {
                        dragItemPosition = Offset.Zero
                        dragging = false
                    })


                }
        )


    }


}