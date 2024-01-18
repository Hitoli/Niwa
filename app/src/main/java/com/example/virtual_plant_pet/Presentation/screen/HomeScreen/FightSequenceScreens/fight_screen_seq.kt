package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.HomeUtils.CardItem
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.HomeUtils.shopItems
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background4
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background5
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundLifeLine
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundWater
import com.example.virtual_plant_pet.ui.theme.virtual_plant_sheetcolor
import com.google.ar.sceneform.rendering.ViewRenderable.VerticalAlignment
import kotlinx.coroutines.delay
import org.koin.core.parameter.parameterArrayOf
import kotlin.math.roundToInt
import kotlin.time.Duration.Companion.seconds

@Composable
fun FightScreenSeq(
    isPad: PaddingValues,
    isOnFightPressed: Boolean,
    onFight: (Boolean) -> Unit,
    onUsedAmountPlant1: (Int) -> Unit,
    onUsedAmountPlant2: (Int) -> Unit,
    onresourceAmount: (Int) -> Unit,
    onGameResult: () -> Unit,
    listOfCard: List<CardItem>,
    usedHealthAmountPlant1: Int,
    totalHealthAmountPlant1: Int,
    usedHealthAmountPlant2: Int,
    totalHealthAmountPlant2: Int,
    resourceAmount: Int,
    resourceTotalAmount: Int
) {
    val config = LocalConfiguration.current
    val screenHeight = config.screenHeightDp.dp
    val screenWidth = config.screenWidthDp.dp
    val density = LocalDensity.current
    val draganime = remember {
        SpringSpec<Int>(stiffness = Spring.StiffnessHigh, visibilityThreshold = 1)
    }
    val dropanime = remember {
        SpringSpec<Int>(stiffness = Spring.StiffnessLow, visibilityThreshold = 1)
    }
    var dragging by remember {
        mutableStateOf(false)
    }
    val animespec = if (dragging) draganime else dropanime

    var InitialPositionx by remember {
        mutableStateOf(0)
    }
    var InitialPositiony by remember {
        mutableStateOf(0)
    }
    var sizeWidth1 by remember {
        mutableStateOf(87.dp)
    }
    var sizeHeight1 by remember {
        mutableStateOf(127.dp)

    }
    var sizeWidth2 by remember {
        mutableStateOf(87.dp)
    }
    var sizeHeight2 by remember {
        mutableStateOf(127.dp)

    }
    var sizeWidth3 by remember {
        mutableStateOf(87.dp)
    }
    var sizeHeight3 by remember {
        mutableStateOf(127.dp)

    }


    var offsetX3 by remember {
        mutableStateOf((screenWidth.value + 280).toInt())
    }
    var offsetY3 by remember {
        mutableStateOf((screenHeight.value * 2 - 150).toInt())
    }
    var offsetx by remember {
        mutableStateOf((screenWidth.value + 30).toInt())
    }
    var offsety by remember {
        mutableStateOf((screenHeight.value * 2 - 150).toInt())
    }
    var offsetXdrag3 = animateIntAsState(
        targetValue = offsetX3, animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag3 = animateIntAsState(
        targetValue = offsetY3, animationSpec = animespec,
        label = "Animation on offset Y"
    )


    var offsetXdrag = animateIntAsState(
        targetValue = offsetx, animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag = animateIntAsState(
        targetValue = offsety, animationSpec = animespec,
        label = "Animation on offset Y"
    )
    var offsetX2 by remember { mutableStateOf((screenWidth.value - 220).toInt()) }
    var offsetY2 by remember { mutableStateOf((screenHeight.value * 2 - 150).toInt()) }
    var dragging2 by remember {
        mutableStateOf(false)
    }
    var offsetXdrag2 = animateIntAsState(
        targetValue = offsetX2, animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag2 = animateIntAsState(
        targetValue = offsetY2, animationSpec = animespec,
        label = "Animation on offset Y"
    )

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
    val resourcePercentagePlant = animateFloatAsState(
        targetValue = resourceAmount.toFloat() / resourceTotalAmount.toFloat(),
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
                            InitialPositionx = this.x.roundToInt() + 15
                            InitialPositiony = this.y.roundToInt() - 30

                        }
                }
        )
        Box(
            modifier = Modifier

                .width(310.dp)
                .offset(x = screenWidth / 8, y = screenHeight * 3 / 4)
                .height(100.dp)
                .background(
                    color = Color(0x4D000000),
                    shape = RoundedCornerShape(size = 10.dp)
                )
        )
        Image(
            painter = painterResource(id = listOfCard[0].cardImage),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds, modifier = Modifier
                .width(sizeWidth2)
                .height(sizeHeight2)
                .offset { IntOffset(offsetXdrag2.value, offsetYdrag2.value) }
                .pointerInput(Unit) {
                    detectDragGestures(onDrag = { change, dragAmount ->

                        sizeWidth2 = 127.dp
                        sizeHeight2 = 187.dp
                        dragging = change.pressed
                        Log.e("dragginf", change.pressed.toString())
                        offsetX2 += dragAmount.x.roundToInt()
                        offsetY2 += dragAmount.y.roundToInt()
                    }, onDragEnd = {
                        onresourceAmount(listOfCard[0].cardValue)
                        onUsedAmountPlant1(listOfCard[0].attackPower)
                        offsetX2 = InitialPositionx
                        offsetY2 = InitialPositiony
                        Log.e("Contains IntialPostion", InitialPositionx.toString())
                        Log.e("Contains IntialPostion", InitialPositiony.toString())
                        Log.e("Contains offsetx", offsetX2.toString())
                        Log.e("Contains offsety", offsetY2.toString())
                    })
                }
        )
        Image(
            painter = painterResource(id = listOfCard[1].cardImage),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds, modifier = Modifier
                .width(sizeWidth1)
                .height(sizeHeight1)
                .offset { IntOffset(offsetXdrag.value, offsetYdrag.value) }
                .pointerInput(Unit) {
                    detectDragGestures(onDrag = { change, dragAmount ->
                        sizeWidth1 = 127.dp
                        sizeHeight1 = 187.dp
                        dragging = change.pressed
                        Log.e("dragginf", change.pressed.toString())
                        offsetx += dragAmount.x.roundToInt()
                        offsety += dragAmount.y.roundToInt()
                    }, onDragEnd = {
                        offsetx = InitialPositionx
                        offsety = InitialPositiony
                        Log.e("Contains IntialPostion", InitialPositionx.toString())
                        Log.e("Contains IntialPostion", InitialPositiony.toString())
                        Log.e("Contains offsetx", offsetx.toString())
                        Log.e("Contains offsety", offsety.toString())

                    })
                }
        )
        Image(
            painter = painterResource(id = listOfCard[2].cardImage),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds, modifier = Modifier
                .width(sizeWidth3)
                .height(sizeHeight3)
                .offset { IntOffset(offsetXdrag3.value, offsetYdrag3.value) }
                .pointerInput(Unit) {
                    detectDragGestures(onDrag = { change, dragAmount ->
                        sizeWidth3 = 127.dp
                        sizeHeight3 = 187.dp
                        dragging = change.pressed
                        Log.e("dragginf", change.pressed.toString())
                        offsetX3 += dragAmount.x.roundToInt()
                        offsetY3 += dragAmount.y.roundToInt()
                    }, onDragEnd = {
                        offsetX3 = InitialPositionx
                        offsetY3 = InitialPositiony
                        Log.e("Contains IntialPostion", InitialPositionx.toString())
                        Log.e("Contains IntialPostion", InitialPositiony.toString())
                        Log.e("Contains offsetx", offsetX3.toString())
                        Log.e("Contains offsety", offsetY3.toString())

                    })
                }
        )




        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(4f),
                    verticalArrangement = Arrangement.Center,
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
                            text = "Mystique",
                            color = Color.Black,
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontSize = 20.sp)
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



                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(4f),
                    verticalArrangement = Arrangement.Center,
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
                                        BorderStroke(1.dp, Color.Black),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ) {
                                val width = size.width
                                val height = size.height
                                val waterWavesYPosition = (1 - healthPercentagePlant2.value) * width
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
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontSize = 20.sp)
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
            }

//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {

//                Box(
//                    modifier = Modifier
//                        .padding(1.dp)
//                        .width(138.dp)
//                        .height(204.dp)
//                        .background(color = Color(0x4D000000), shape = RoundedCornerShape(10.dp))
//                )
//            }
            Spacer(modifier = Modifier.size(40.dp))

            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(modifier = Modifier) {


                    Row(
                        modifier = Modifier
                            .width(300.dp)
                            .heightIn(max = 60.dp)
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
                                .width(300.dp)
                                .height(60.dp)
                                .clip(RoundedCornerShape(8.dp))
                        ) {
                            val width = size.width
                            val height = size.height
                            val waterWavesYPosition = (resourcePercentagePlant.value) * width
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

                            drawPath(waterPath, virtual_plant_backgroundWater)


                        }
                        Spacer(modifier = Modifier.size(6.dp))

                    }

                }
                Spacer(modifier = Modifier.size(10.dp))
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0x4D000000))
                        .padding(16.dp)
                ) {
                    if (resourceAmount >= resourceTotalAmount) {
                        Icon(
                            painter = painterResource(R.drawable.water),
                            contentDescription = "water",
                            modifier = Modifier.size(30.dp),
                            tint = Color.White
                        )
                    } else {
                        Text(
                            text = resourceAmount.toString(),
                            color = Color.White,
                            modifier = Modifier
                                .size(30.dp),
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontSize = 20.sp)
                        )
                    }

                }
            }
//
//            FightScreenSeqGameResult(true, onVisible = {
//
//            }, onDone = {})


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FightScreenSeqGameResult(
    onIsVisible: Boolean,
    onVisible: (Boolean) -> Unit,
    onDone: () -> Unit
) {
    if (onIsVisible) {
        AlertDialog(
            onDismissRequest = { },
            properties = DialogProperties(false, false),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
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
                    text = "Resources Won",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 20.sp)
                )
                AppNavMapIndicatorAlertBox(
                    usedWaterAmount = 20,
                    totalSolarAmount = 100,
                    totalSoilAmount = 100,
                    totalWaterAmount = 100,
                    usedSolarAmount = 40,
                    usedSoilAmount = 40
                )



                Button(
                    onClick = {
                        onDone()
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .heightIn(65.dp)
                        .widthIn(120.dp)
                        .border(
                            BorderStroke(width = 0.5.dp, Color.Black),
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
fun AppNavMapIndicatorAlertBox(
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

    Box(modifier = Modifier.background(Color(0x4D000000), shape = RoundedCornerShape(16.dp))) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VirtualPlantScreenResourcesIndicator(
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
fun VirtualPlantScreenResourcesIndicator(modifier: Modifier, water: Int, soil: Int, solar: Int) {
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
            Text(text = water.toString(), color = Color.Black, fontSize = 20.sp)
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
            Text(text = soil.toString(), color = Color.Black, fontSize = 20.sp)
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
            Text(text = solar.toString(), color = Color.Black, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.size(12.dp))
//

    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFightScreenSeq() {
    var timerTicks by remember {
        mutableStateOf(0)
    }
    var resourceAmount by remember {
        mutableStateOf(0)
    }
    var totalResourceAmount by remember {
        mutableStateOf(120)
    }
    var onTotalAmountPlant1 by remember {
        mutableStateOf(120)
    }
    var onUsedAmountPlant1 by remember {
        mutableStateOf(0)
    }
    var onTotalAmountPlant2 by remember {
        mutableStateOf(120)
    }
    var onUsedAmountPlant2 by remember {
        mutableStateOf(0)
    }
    var cardList = listOf<CardItem>(
        CardItem(cardImage = R.drawable.niwaplayingcard, 5, 10),
        CardItem(cardImage = R.drawable.niwaplayingcard, 5, 10),
        CardItem(cardImage = R.drawable.niwaplayingcard, 5, 10),
    )
    LaunchedEffect(key1 = Unit) {
        while (resourceAmount <= totalResourceAmount) {
            delay(1.5.seconds)
            timerTicks++;
            resourceAmount += 5;
        }
    }
    FightScreenSeq(
        isOnFightPressed = true,
        isPad = PaddingValues(16.dp),
        onFight = {

        },
        onUsedAmountPlant2 = {},
        onUsedAmountPlant1 = {
                             onUsedAmountPlant1 = it
        },
        onGameResult = {},
        usedHealthAmountPlant2 = onUsedAmountPlant2,
        usedHealthAmountPlant1 = onUsedAmountPlant1,
        totalHealthAmountPlant1 = onTotalAmountPlant1,
        totalHealthAmountPlant2 = onTotalAmountPlant2,
        resourceAmount = resourceAmount,
        resourceTotalAmount = totalResourceAmount, onresourceAmount = {
            resourceAmount -= it
        }, listOfCard = cardList
    )
}