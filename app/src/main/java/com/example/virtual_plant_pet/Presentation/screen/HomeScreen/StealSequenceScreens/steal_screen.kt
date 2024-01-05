package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StealSequenceScreens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.virtual_plant_pet.R

import com.example.virtual_plant_pet.Presentation.screen.screenmodals.CardFace
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun StealScreen(onCapture: (Int, Boolean) -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    var offsetx2 by remember {
        mutableStateOf(Random.nextInt(0, 170))
    }
    var offsety2 by remember {
        mutableStateOf(Random.nextInt(0, 50))
    }
    var isAddedtoGarden by remember {
        mutableStateOf(false)
    }
    var Image2 by remember {
        mutableIntStateOf(0)
    }
    var isCaptured2 by remember {
        mutableStateOf(false)
    }
    val value1 by rememberInfiniteTransition().animateFloat(
        initialValue = 1.dp.value,
        targetValue = 3.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1300,
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.wildscnress),
            contentDescription = "landscape",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        ) {
//            PlantsInTheWildScreenPlantCard(
//                x = offsetx1.dp,
//                y = offsety1.dp,
//                image = R.drawable.p21,value, onCapture = { img, captured->
//                    Image3 = R.drawable.p21
//                    isCaptured1 = captured
//                }
//            )
            if (!isAddedtoGarden) {
                StealScreenPlantCard(
                    x = offsetx2.dp,
                    y = offsety2.dp,
                    image = R.drawable.p35, value = value1, onCapture = { img, captured ->
                        Image2 = R.drawable.p35
                        isCaptured2 = captured
                    }
                )
            }


//            PlantsInTheWildScreenPlantCard(
//                x = offsetx3.dp,
//                y = offsety3.dp,
//                image = R.drawable.p23, value = value2, onCapture = {img, captured->
//                    Image1 = R.drawable.p23
//                    isCaptured3 = captured
//                }
//            )
        }
    }
}

@Composable
fun StealScreenPlantCard(
    x: Dp,
    y: Dp,
    image: Int,
    value: Float,
    onCapture: (Int, Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .offset(x = x, y = y)
            .clickable {
                onCapture(image, true)
            }
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "petplantname",
            modifier = Modifier
                .size(85.dp)
                .offset(x = value.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewStealScreen() {
    StealScreen(onCapture = {
        i, b ->
    })
}