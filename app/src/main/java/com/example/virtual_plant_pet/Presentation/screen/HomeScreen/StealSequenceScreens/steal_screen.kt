package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StealSequenceScreens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background4
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background5
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundLifeLine
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundWater
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun StealScreen(onCapture: (Int, Boolean) -> Unit) {
    var totalHealthAmountPlant1 by remember {
        mutableStateOf(400)
    }
    var usedHealthAmountPlant1 by remember {
        mutableStateOf(0)
    }
    var totalHealthAmountPlant2 by remember {
        mutableStateOf(400)
    }
    var usedHealthAmountPlant2 by remember {
        mutableStateOf(0)
    }
    val healthPercentagePlant1 = animateFloatAsState(
        targetValue = usedHealthAmountPlant1.toFloat() / totalHealthAmountPlant1.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )
    val healthPercentagePlant2 = animateFloatAsState(
        targetValue = usedHealthAmountPlant2.toFloat() / totalHealthAmountPlant2.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.width(250.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(202.dp)
                            .height(75.dp)
                            .background(
                                color = Color(0x4D000000),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(300.dp)
                            .offset(x = 30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.backofplayingcardniwa),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .width(87.dp)
                                .height(127.dp)
                                .offset(y = 60.dp)
                                .graphicsLayer {
                                    rotationZ = 20f
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.backofplayingcardniwa),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .width(87.dp)
                                .height(127.dp)
                                .offset(y = 75.dp, x = -30.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.backofplayingcardniwa),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .width(87.dp)
                                .height(127.dp)
                                .offset(y = 60.dp, x = -60.dp)
                                .graphicsLayer {
                                    rotationZ = -20f
                                }
                        )
                    }


                }
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.farmers),
                        contentDescription = "player",
                        contentScale = ContentScale.FillBounds, modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                    )
                    Spacer(modifier = Modifier.size(10.dp))

                    ElevatedCard(
                        modifier = Modifier
                            .shadow(
                                elevation = 10.dp,
                                spotColor = Color.Gray,
                                shape = RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .border(
                                border = BorderStroke(0.2.dp, Color.Gray),
                                shape = RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .width(200.dp)
                            .height(100.dp)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            ), colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .width(200.dp)
                                .heightIn(max = 50.dp)
                                .padding(10.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Black,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Canvas(
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .border(
                                        BorderStroke(0.2.dp, Color.Black),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ) {
                                val width = size.width
                                val height = size.height
                                val waterWavesYPosition = (1 - healthPercentagePlant1.value) * width
                                val waterPath = Path().apply {
                                    moveTo(
                                        x = 0f,
                                        y = 0f
                                    )
                                    lineTo(
                                        x = waterWavesYPosition,
                                        y = 0f
                                    )
                                    lineTo(
                                        x = waterWavesYPosition,
                                        y = height
                                    )
                                    lineTo(
                                        x = 0f,
                                        y = height
                                    )
                                    close()
                                }

                                drawPath(waterPath, virtual_plant_backgroundLifeLine)


                            }
                            Spacer(modifier = Modifier.size(6.dp))

                        }
                        Text(
                            text = "Sam",
                            color = Color.Black,
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .fillMaxWidth(), textAlign = TextAlign.Center, style = TextStyle(fontSize = 20.sp)
                        )
                    }
                }


            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .padding(1.dp)
                        .width(138.dp)
                        .height(204.dp)
                        .background(color = Color(0x4D000000), shape = RoundedCornerShape(10.dp))
                )
                Box(
                    modifier = Modifier
                        .padding(1.dp)
                        .width(138.dp)
                        .height(204.dp)
                        .background(color = Color(0x4D000000), shape = RoundedCornerShape(10.dp))
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.weight(4f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedCard(
                        modifier = Modifier
                            .shadow(
                                elevation = 10.dp,
                                spotColor = Color.Gray,
                                shape = RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .border(
                                border = BorderStroke(0.2.dp, Color.Gray),
                                shape = RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .width(200.dp)
                            .height(100.dp)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            ), colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .width(200.dp)
                                .heightIn(max = 50.dp)
                                .padding(10.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Black,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Canvas(
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .border(
                                        BorderStroke(0.2.dp, Color.Black),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ) {
                                val width = size.width
                                val height = size.height
                                val waterWavesYPosition = (1 - healthPercentagePlant1.value) * width
                                val waterPath = Path().apply {
                                    moveTo(
                                        x = 0f,
                                        y = 0f
                                    )
                                    lineTo(
                                        x = waterWavesYPosition,
                                        y = 0f
                                    )
                                    lineTo(
                                        x = waterWavesYPosition,
                                        y = height
                                    )
                                    lineTo(
                                        x = 0f,
                                        y = height
                                    )
                                    close()
                                }

                                drawPath(waterPath, virtual_plant_backgroundLifeLine)


                            }
                            Spacer(modifier = Modifier.size(6.dp))

                        }
                        Text(
                            text = "Hitesh",
                            color = Color.Black,
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .fillMaxWidth(), textAlign = TextAlign.Center, style = TextStyle(fontSize = 20.sp)
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.farmers),
                        contentDescription = "player",
                        contentScale = ContentScale.FillBounds, modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                    )



                }
                Box(
                    modifier = Modifier.width(250.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(202.dp)
                            .height(75.dp)
                            .background(
                                color = Color(0x4D000000),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(300.dp)
                            .offset(x = 30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.backofplayingcardniwa),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .width(87.dp)
                                .height(127.dp)
                                .offset(y = -60.dp)
                                .graphicsLayer {
                                    rotationZ = -20f
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.backofplayingcardniwa),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .width(87.dp)
                                .height(127.dp)
                                .offset(y = -75.dp, x = -30.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.backofplayingcardniwa),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .width(87.dp)
                                .height(127.dp)
                                .offset(y = -60.dp, x = -60.dp)
                                .graphicsLayer {
                                    rotationZ = 20f
                                }
                        )
                    }


                }


            }

        }
        StealScreenSeqGameResult(onDone = {

        }, onVisible = {}, onIsVisible = true)

    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StealScreenSeqGameResult(onIsVisible: Boolean, onVisible: (Boolean) -> Unit, onDone: () -> Unit) {
    if (onIsVisible) {
        AlertDialog(
            onDismissRequest = { },
            properties = DialogProperties(false, false),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .clip(
                    RoundedCornerShape(24.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.farmers),
                    contentDescription = "player",
                    contentScale = ContentScale.FillBounds, modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
                Text(
                    text = "Resources Won & Card Won",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .fillMaxWidth(), textAlign = TextAlign.Center, style = TextStyle(fontSize = 20.sp)
                )
                StealAppNavMapIndicatorAlertBox(usedWaterAmount = 20, totalSolarAmount = 100, totalSoilAmount = 100, totalWaterAmount = 100, usedSolarAmount = 40, usedSoilAmount = 40)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(
                            color = Color(0x4D000000),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                ){
                    Image(
                        painter = painterResource(id = R.drawable.niwaplayingcard),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds, modifier = Modifier
                            .width(87.dp)
                            .height(127.dp).align(Alignment.Center)

                    )

                }


                Button(
                    onClick = {
                        onDone()
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .heightIn(65.dp)
                        .widthIn(120.dp).border(BorderStroke(width = 0.5.dp,Color.Black),
                            RoundedCornerShape(10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        virtual_plant_background7
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Done",
                        modifier = Modifier
                            .widthIn(50.dp),
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start
                    )
                }


            }


        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StealAppNavMapIndicatorAlertBox(
    usedWaterAmount: Int,
    totalWaterAmount: Int,
    usedSoilAmount: Int,
    totalSoilAmount: Int,
    usedSolarAmount: Int,
    totalSolarAmount: Int,
) {

    val waterPercentage = animateFloatAsState(
        targetValue = usedWaterAmount.toFloat() / totalWaterAmount.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )
    val soilPercentage = animateFloatAsState(
        targetValue = usedSoilAmount.toFloat() / totalSoilAmount.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )
    val solarPercentage = animateFloatAsState(
        targetValue = usedSolarAmount.toFloat() / totalSolarAmount.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )

    Box(modifier = Modifier.background(Color(0x4D000000), shape = RoundedCornerShape(16.dp))){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StealVirtualPlantScreenResourcesIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(50.dp)

                    .background(Color.Transparent, RoundedCornerShape(16.dp)),
                usedWaterAmount, usedSoilAmount, usedSolarAmount
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier
                        .width(70.dp)
                        .fillMaxHeight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Canvas(
                        modifier = Modifier
                            .width(70.dp)
                            .height(100.dp)
                    ) {
                        val width = size.width
                        val height = size.height
                        val waterWavesYPosition = (1 - waterPercentage.value) * height
                        val waterPath = Path().apply {
                            moveTo(
                                x = 0f,
                                y = waterWavesYPosition
                            )
                            lineTo(
                                x = width - 20f,
                                y = waterWavesYPosition
                            )
                            lineTo(
                                x = width - 20f,
                                y = height
                            )
                            lineTo(
                                x = 0f,
                                y = height
                            )
                            close()
                        }

                        drawPath(waterPath, virtual_plant_backgroundWater)


                    }
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = "Water",
                        color = Color.White,
                        modifier = Modifier
                            .padding(6.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .width(70.dp)
                        .fillMaxHeight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Canvas(
                        modifier = Modifier
                            .width(70.dp)
                            .height(100.dp)
                    ) {
                        val width = size.width
                        val height = size.height
                        val waterWavesYPosition = (1 - soilPercentage.value) * height
                        val waterPath = Path().apply {
                            moveTo(
                                x = 0f,
                                y = waterWavesYPosition
                            )
                            lineTo(
                                x = width - 20f,
                                y = waterWavesYPosition
                            )
                            lineTo(
                                x = width - 20f,
                                y = height
                            )
                            lineTo(
                                x = 0f,
                                y = height
                            )
                            close()
                        }

                        drawPath(waterPath, virtual_plant_background4)


                    }
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = "Soil",
                        color = Color.White,
                        modifier = Modifier
                            .padding(6.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .width(70.dp)
                        .fillMaxHeight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Canvas(
                        modifier = Modifier
                            .width(70.dp)
                            .height(100.dp)
                    ) {
                        val width = size.width
                        val height = size.height
                        val waterWavesYPosition = (1 - solarPercentage.value) * height
                        val waterPath = Path().apply {
                            moveTo(
                                x = 0f,
                                y = waterWavesYPosition
                            )
                            lineTo(
                                x = width - 20f,
                                y = waterWavesYPosition
                            )
                            lineTo(
                                x = width - 20f,
                                y = height
                            )
                            lineTo(
                                x = 0f,
                                y = height
                            )
                            close()
                        }

                        drawPath(waterPath, virtual_plant_background5)


                    }
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = "Solar",
                        color = Color.White,
                        modifier = Modifier
                            .padding(6.dp)
                    )
                }

            }

        }
    }





}
@Composable
fun StealVirtualPlantScreenResourcesIndicator(modifier: Modifier, water: Int, soil: Int, solar: Int) {
    Row(
        modifier = modifier
            .padding(top = 8.dp, end = 10.dp, start = 10.dp, bottom = 1.dp)
            .clip(RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier
                .widthIn(10.dp)
                .heightIn(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.water),
                modifier = Modifier.size(35.dp),
                contentDescription = "water",
                colorFilter = ColorFilter.tint(
                    Color.Black

                )
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = water.toString(), color =  Color.Black, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier
                .widthIn(10.dp)
                .heightIn(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.soil),
                modifier = Modifier.size(35.dp),
                contentDescription = "water",
                colorFilter = ColorFilter.tint(
                    Color.Black
                )
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = soil.toString(), color =  Color.Black, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier
                .widthIn(10.dp)
                .heightIn(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunshine),
                modifier = Modifier.size(35.dp),
                contentDescription = "water",
                colorFilter = ColorFilter.tint(
                    Color.Black
                )
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = solar.toString(), color =  Color.Black, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.size(12.dp))
//

    }

}



@Preview(showBackground = true)
@Composable
fun PreviewStealScreen() {
    StealScreen(onCapture = { i, b ->
    })
}