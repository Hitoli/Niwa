package com.example.virtual_plant_pet.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundNight
import com.example.virtual_plant_pet.ui.theme.virtual_plant_sheetcolor
import com.example.virtual_plant_pet.ui.theme.virual_plant_background1
import com.example.virtual_plant_pet.utils.WavyShape
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

//@Preview(showBackground = true)
@Composable
fun PlantsInTheWildScreen(pad: PaddingValues) {
//    PlantInTheWildOnBoardingAlert()
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = virtual_plant_background,
        targetValue = virtual_plant_backgroundNight,
        animationSpec = infiniteRepeatable(
            animation = tween(1000000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    var offsetx1 by remember {
        mutableStateOf(Random.nextInt(0, 100))
    }
    var offsety1 by remember {
        mutableStateOf(Random.nextInt(0, 50))
    }
    var offsetx2 by remember {
        mutableStateOf(Random.nextInt(101, 170))
    }
    var offsety2 by remember {
        mutableStateOf(Random.nextInt(50, 100))
    }
    var offsetx3 by remember {
        mutableStateOf(Random.nextInt(171, 250))
    }
    var offsety3 by remember {
        mutableStateOf(Random.nextInt(100, 150))
    }
    var wave by remember {
        mutableStateOf(WavyShape(100.dp, 50.dp))
    }
    var isVisible by remember {
        mutableStateOf(false)
    }
    var isVisible1 by remember {
        mutableStateOf(false)
    }
    var isVisible2 by remember {
        mutableStateOf(false)
    }
    val corotine = rememberCoroutineScope()



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.niwaback2),
            contentDescription = "landscape",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.align(Alignment.TopStart).padding(
            top=150.dp, start = 20.dp
        )) {
            Row(modifier = Modifier
                .widthIn(50.dp)
                .heightIn(50.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                ElevatedCard(
                    modifier = Modifier
                        .widthIn(50.dp)
                        .heightIn(50.dp)
                        .clip(
                            CircleShape
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.wildnawi),
                        contentDescription = "Plant",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(6.dp)
                            .clickable {
                                isVisible = true
                                corotine.launch {
                                    delay(1500)
                                    isVisible = false
                                }

                            }, tint = Color.Black
                    )

                }
                AnimatedVisibility(
                    visible = isVisible,
                    enter = slideInHorizontally()+ fadeIn(animationSpec = tween(durationMillis = 400)),
                    exit = slideOutHorizontally()+ fadeOut(animationSpec = tween(durationMillis = 400))
                ) {
                    Text(
                        text = "Explore",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp),
                        fontSize = 18.sp, color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Default, textAlign = TextAlign.Start
                    )
                }

            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(modifier = Modifier
                .widthIn(50.dp)
                .heightIn(50.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                ElevatedCard(
                    modifier = Modifier
                        .widthIn(50.dp)
                        .heightIn(50.dp)
                        .clip(
                            CircleShape
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.notesniwa),
                        contentDescription = "Plant",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(6.dp)
                            .clickable {
                                isVisible1 = true
                                corotine.launch {
                                    delay(1500)
                                    isVisible1 = false
                                }

                            }, tint = Color.Black
                    )

                }
                AnimatedVisibility(
                    visible = isVisible1,
                    enter = slideInHorizontally()+ fadeIn(animationSpec = tween(durationMillis = 400)),
                    exit = slideOutHorizontally()+ fadeOut(animationSpec = tween(durationMillis = 400))
                ) {
                    Text(
                        text = "Challenges",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp),
                        fontSize = 18.sp, color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Default, textAlign = TextAlign.Start
                    )
                }

            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(modifier = Modifier
                .widthIn(50.dp)
                .heightIn(50.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                ElevatedCard(
                    modifier = Modifier
                        .widthIn(50.dp)
                        .heightIn(50.dp)
                        .clip(
                            CircleShape
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bonusniwa),
                        contentDescription = "Plant",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(6.dp)
                            .clickable {
                                isVisible2 = true
                                corotine.launch {
                                    delay(1500)
                                    isVisible2 = false
                                }

                            }, tint = Color.Black
                    )

                }
                AnimatedVisibility(
                    visible = isVisible2,
                    enter = slideInHorizontally()+ fadeIn(animationSpec = tween(durationMillis = 400)),
                    exit = slideOutHorizontally()+ fadeOut(animationSpec = tween(durationMillis = 400))
                ) {
                    Text(
                        text = "Bonus",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp),
                        fontSize = 18.sp, color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Default, textAlign = TextAlign.Start
                    )
                }

            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        ) {
            PlantsInTheWildScreenPlantCard(
                x = offsetx1.dp,
                y = offsety1.dp,
                image = R.drawable.p21
            )

            PlantsInTheWildScreenPlantCard(
                x = offsetx2.dp,
                y = offsety2.dp,
                image = R.drawable.p22
            )

            PlantsInTheWildScreenPlantCard(
                x = offsetx3.dp,
                y = offsety3.dp,
                image = R.drawable.p23
            )
        }
    }


}


@Composable
fun PlantsInTheWildScreenPlantCard(x: Dp, y: Dp, image: Int) {
    Box(
        modifier = Modifier.offset(x = x, y = y)
    ) {
//        ElevatedCard(
//            modifier = Modifier
//                .shadow(
//                    elevation = 10.dp,
//                    spotColor = Color.Gray,
//                    shape = RoundedCornerShape(24.dp)
//                )
//                .border(
//                    border = BorderStroke(0.2.dp, Color.Gray),
//                    shape = RoundedCornerShape(24.dp)
//                )
//                .widthIn(85.dp)
//                .heightIn(85.dp)
//                .clip(
//                    RoundedCornerShape(24.dp)
//                )
//                .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
//        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "petplantname",
                modifier = Modifier.size(85.dp)
            )
//        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantInTheWildOnBoardingAlert() {

    var dismiss by remember {
        mutableStateOf(true)
    }
    if (dismiss) {

        AlertDialog(
            onDismissRequest = { dismiss },
            properties = DialogProperties(false, false),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .clip(
                    RoundedCornerShape(24.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Welcome To The Wild",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "You can find plants in the wild",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Click on them to add them to your garden",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                ButtonScreen(
                    value = "Ok, Got it",
                    onClick = { dismiss = false },
                    height = 60.dp,
                    width = 300.dp
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlantsInTheWildScreenPreview() {
//    PlantInTheWildOnBoardingAlert()
    PlantsInTheWildScreen(
        PaddingValues(10.dp)
    )
}