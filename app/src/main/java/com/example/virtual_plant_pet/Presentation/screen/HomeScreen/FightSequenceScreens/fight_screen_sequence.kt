package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.model.content.CircleShape
import com.example.solus.authScreens.authUtils.MyCircle
import com.example.virtual_plant_pet.Presentation.screen.screenmodals.PlantAttacks
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background8
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundBlackShade
import com.example.virtual_plant_pet.ui.theme.virtual_plant_sheetcolor
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import kotlin.time.Duration.Companion.seconds

@Composable
fun BattleScreen(
    isPad: PaddingValues,
    isOnVisible: Boolean,
    isOnFightPressed: Boolean,
    isOnAttackingPlant: String,
    onFight: (Boolean) -> Unit,
    onVisible: (Boolean) -> Unit,
    onAttack: (String) -> Unit,
    onUsedAmountPlant1: (Int) -> Unit,
    onUsedAmountPlant2: (Int) -> Unit,
    onGameResult: () -> Unit,
    usedHealthAmountPlant1: Int,
    totalHealthAmountPlant1: Int,
    usedHealthAmountPlant2: Int,
    totalHealthAmountPlant2: Int,
) {



    var sizeWidth1 by remember {
        mutableStateOf(60.dp)
    }
    var sizeHeight1 by remember {
        mutableStateOf(80.dp)
    }

    var sizeWidth2 by remember {
        mutableStateOf(60.dp)
    }
    var sizeHeight2 by remember {
        mutableStateOf(80.dp)
    }

    var sizeWidth3 by remember {
        mutableStateOf(60.dp)
    }
    var sizeHeight3 by remember {
        mutableStateOf(80.dp)
    }

    var sizeWidth4 by remember {
        mutableStateOf(60.dp)
    }
    var sizeHeight4 by remember {
        mutableStateOf(80.dp)
    }

    var sizeWidth5 by remember {
        mutableStateOf(60.dp)
    }
    var sizeHeight5 by remember {
        mutableStateOf(80.dp)
    }

    var sizeWidth6 by remember {
        mutableStateOf(60.dp)
    }
    var sizeHeight6 by remember {
        mutableStateOf(80.dp)
    }
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.petalstorm))
    var InitialPositionx by remember {
        mutableStateOf(0f)
    }
    var InitialPositiony by remember {
        mutableStateOf(0f)
    }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var dragging by remember {
        mutableStateOf(false)
    }
    val draganime = remember {
        SpringSpec<Int>(stiffness = Spring.StiffnessHigh, visibilityThreshold = 1)
    }
    val dropanime = remember {
        SpringSpec<Int>(stiffness = Spring.StiffnessLow, visibilityThreshold = 1)
    }
    val animespec = if (dragging) draganime else dropanime

    var offsetXdrag = animateIntAsState(
        targetValue = offsetX.roundToInt(), animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag = animateIntAsState(
        targetValue = offsetY.roundToInt(), animationSpec = animespec,
        label = "Animation on offset Y"
    )

    var offsetX2 by remember { mutableFloatStateOf(0f) }
    var offsetY2 by remember { mutableFloatStateOf(0f) }
    var dragging2 by remember {
        mutableStateOf(false)
    }

    var offsetXdrag2 = animateIntAsState(
        targetValue = offsetX2.roundToInt(), animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag2 = animateIntAsState(
        targetValue = offsetY2.roundToInt(), animationSpec = animespec,
        label = "Animation on offset Y"
    )

    var offsetX3 by remember { mutableFloatStateOf(0f) }
    var offsetY3 by remember { mutableFloatStateOf(0f) }
    var dragging3 by remember {
        mutableStateOf(false)
    }


    var offsetXdrag3 = animateIntAsState(
        targetValue = offsetX3.roundToInt(), animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag3 = animateIntAsState(
        targetValue = offsetY3.roundToInt(), animationSpec = animespec,
        label = "Animation on offset Y"
    )
    var offsetX4 by remember { mutableFloatStateOf(0f) }
    var offsetY4 by remember { mutableFloatStateOf(0f) }
    var dragging4 by remember {
        mutableStateOf(false)
    }


    var offsetXdrag4 = animateIntAsState(
        targetValue = offsetX4.roundToInt(), animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag4 = animateIntAsState(
        targetValue = offsetY4.roundToInt(), animationSpec = animespec,
        label = "Animation on offset Y"
    )
    var offsetX5 by remember { mutableFloatStateOf(0f) }
    var offsetY5 by remember { mutableFloatStateOf(0f) }
    var dragging5 by remember {
        mutableStateOf(false)
    }


    var offsetXdrag5 = animateIntAsState(
        targetValue = offsetX5.roundToInt(), animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag5 = animateIntAsState(
        targetValue = offsetY5.roundToInt(), animationSpec = animespec,
        label = "Animation on offset Y"
    )
    var offsetX6 by remember { mutableFloatStateOf(0f) }
    var offsetY6 by remember { mutableFloatStateOf(0f) }
    var dragging6 by remember {
        mutableStateOf(false)
    }


    var offsetXdrag6 = animateIntAsState(
        targetValue = offsetX6.roundToInt(), animationSpec = animespec,
        label = "Animation on offset X"
    )
    var offsetYdrag6 = animateIntAsState(
        targetValue = offsetY6.roundToInt(), animationSpec = animespec,
        label = "Animation on offset Y"
    )


    val infiniteTransition = rememberInfiniteTransition()
    val value by infiniteTransition.animateFloat(
        initialValue = 2f,
        targetValue = 15f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 300,
                delayMillis = 350,
                easing = FastOutSlowInEasing
            )
        )
    )
    val AttakPlants = listOf(
        PlantAttacks(attacksName = "Poison Seed", R.drawable.posionseeds),
        PlantAttacks(attacksName = "Petal Storm", R.drawable.petalstorms)
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(virtual_plant_background3, virtual_plant_background7),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp, top = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //plant1
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
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
                            .height(50.dp)
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

                                drawPath(waterPath, virtual_plant_sheetcolor)


                            }
                            Spacer(modifier = Modifier.size(6.dp))

                        }



                    }
                    if (isOnFightPressed) {
                        Image(
                            painter = painterResource(id = R.drawable.p31),
                            contentDescription = "playarea",
                            modifier = Modifier
                                .weight(3f)
                                .size(80.dp)
                                .clip(RoundedCornerShape(24.dp)), colorFilter = ColorFilter.tint(
                                virtual_plant_background8
                            ), alignment = Alignment.CenterStart
                        )

                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.p31),
                            contentDescription = "playarea",
                            modifier = Modifier
                                .weight(3f)
                                .size(80.dp)

                                .clip(RoundedCornerShape(24.dp)),
                        )
                    }


                }


            }
            //plant 1 cards
            Box(
                modifier = Modifier

                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(10.dp)
                    .background(
                        Color.White.copy(alpha = 0.5f), RoundedCornerShape(24.dp)
                    )


            ) {
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 30.dp)
                            .padding(4.dp)
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
                                .fillMaxWidth()
                                .height(30.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(8.dp))
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

                            drawPath(waterPath, virtual_plant_sheetcolor)


                        }
                        Spacer(modifier = Modifier.size(6.dp))

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            Modifier
                                .offset { IntOffset(offsetXdrag.value, offsetYdrag.value) }
                                .background(Color.Transparent, RoundedCornerShape(10.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .border(
                                    border = BorderStroke(0.2.dp, Color.Gray),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(sizeWidth1, sizeHeight1)
                                .pointerInput(Unit) {
                                    detectDragGestures(onDrag = { change, dragAmount ->
                                        sizeWidth1 = 100.dp
                                        sizeHeight1 = 180.dp
                                        change.consume()
                                        dragging = change.pressed
                                        Log.e("dragginf", change.pressed.toString())
                                        offsetX += dragAmount.x
                                        offsetY += dragAmount.y
                                    }, onDragEnd = {
                                        offsetX = InitialPositionx
                                        offsetY = -InitialPositiony
                                    })
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playingcardniwa),
                                contentDescription = "cards",
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(0.dp))
                            )
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        Box(
                            Modifier
                                .offset { IntOffset(offsetXdrag2.value, offsetYdrag2.value) }
                                .background(Color.Transparent, RoundedCornerShape(10.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .border(
                                    border = BorderStroke(0.2.dp, Color.Gray),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(sizeWidth2, sizeHeight2)
                                .pointerInput(Unit) {
                                    detectDragGestures(onDrag = { change, dragAmount ->
                                        sizeWidth2 = 100.dp
                                        sizeHeight2 = 180.dp
                                        change.consume()
                                        dragging2 = change.pressed
                                        Log.e("dragginf", change.pressed.toString())
                                        offsetX2 += dragAmount.x
                                        offsetY2 += dragAmount.y
                                    }, onDragEnd = {
                                        offsetX2 = InitialPositionx
                                        offsetY2 = -InitialPositiony
                                    })
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playingcardniwa1),
                                contentDescription = "cards",
                                contentScale = ContentScale.Crop, alignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(0.dp))
                            )
                        }
                        Spacer(modifier = Modifier.size(8.dp))

                        Box(
                            Modifier
                                .offset { IntOffset(offsetXdrag3.value, offsetYdrag3.value) }
                                .background(Color.Transparent, RoundedCornerShape(10.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .border(
                                    border = BorderStroke(0.2.dp, Color.Gray),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(sizeWidth3, sizeHeight3)
                                .pointerInput(Unit) {
                                    detectDragGestures(onDrag = { change, dragAmount ->
                                        sizeWidth3 = 100.dp
                                        sizeHeight3 = 180.dp
                                        change.consume()
                                        dragging3 = change.pressed
                                        Log.e("dragginf", change.pressed.toString())
                                        offsetX3 += dragAmount.x
                                        offsetY3 += dragAmount.y
                                    }, onDragEnd = {
                                        offsetX3 = InitialPositionx
                                        offsetY3 = -InitialPositiony
                                    })
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playingcardniwa1),
                                contentDescription = "cards",
                                contentScale = ContentScale.Crop, alignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(0.dp))
                            )
                        }
                    }


                }


            }
            //placeholder
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .padding(10.dp)
                .border(
                    BorderStroke(1.dp, Color.Black),
                    RoundedCornerShape(10.dp)
                )
                .onGloballyPositioned { coordinates ->
                    InitialPositionx = coordinates.positionInParent().x - 50f
                    InitialPositiony = -coordinates.positionInRoot().y + 400f
                    Log.e("InitialPositiony", InitialPositiony.toString())
                    Log.e("InitialPositionx", InitialPositionx.toString())
                })

            //PLant2 cards
            Box(
                modifier = Modifier

                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(10.dp)
                    .background(
                        Color.White.copy(alpha = 0.5f), RoundedCornerShape(24.dp)
                    )

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            Modifier
                                .offset { IntOffset(offsetXdrag4.value, offsetYdrag4.value) }
                                .background(Color.White, RoundedCornerShape(10.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .border(
                                    border = BorderStroke(0.2.dp, Color.Gray),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(sizeWidth4, sizeHeight4)
                                .pointerInput(Unit) {
                                    detectDragGestures(onDrag = { change, dragAmount ->
                                        sizeWidth4 = 80.dp
                                        sizeHeight4 = 280.dp
                                        change.consume()
                                        dragging4 = change.pressed
                                        Log.e("dragginf", change.pressed.toString())
                                        offsetX4 += dragAmount.x
                                        offsetY4 += dragAmount.y
                                    }, onDragEnd = {
                                        onFight(true)
                                        onUsedAmountPlant1(100)
                                        offsetX4 = InitialPositionx
                                        offsetY4 = InitialPositiony
                                    })
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playingcardniwa1),
                                contentDescription = "cards",
                                contentScale = ContentScale.Crop, alignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(0.dp))
                            )

                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        Box(
                            Modifier
                                .offset { IntOffset(offsetXdrag5.value, offsetYdrag5.value) }
                                .background(Color.Transparent, RoundedCornerShape(10.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .border(
                                    border = BorderStroke(0.2.dp, Color.Gray),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(sizeWidth5, sizeHeight5)
                                .pointerInput(Unit) {
                                    detectDragGestures(onDrag = { change, dragAmount ->
                                        sizeWidth5 = 100.dp
                                        sizeHeight5 = 180.dp
                                        change.consume()
                                        dragging5 = change.pressed
                                        Log.e("dragginf", change.pressed.toString())
                                        offsetX5 += dragAmount.x
                                        offsetY5 += dragAmount.y
                                    }, onDragEnd = {
                                        offsetX5 = InitialPositionx
                                        offsetY5 = InitialPositiony
                                    })
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playingcardniwa5),
                                contentDescription = "cards",
                                contentScale = ContentScale.Crop, alignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(0.dp))
                            )
                        }
                        Spacer(modifier = Modifier.size(8.dp))

                        Box(
                            Modifier
                                .offset { IntOffset(offsetXdrag6.value, offsetYdrag6.value) }
                                .background(Color.Transparent, RoundedCornerShape(10.dp))
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .border(
                                    border = BorderStroke(0.2.dp, Color.Gray),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .size(sizeWidth6, sizeHeight6)
                                .pointerInput(Unit) {
                                    detectDragGestures(onDrag = { change, dragAmount ->
                                        sizeWidth6 = 100.dp
                                        sizeHeight6 = 180.dp
                                        change.consume()
                                        dragging6 = change.pressed
                                        Log.e("dragginf", change.pressed.toString())
                                        offsetX6 += dragAmount.x
                                        offsetY6 += dragAmount.y
                                    }, onDragEnd = {
                                        offsetX6 = InitialPositionx
                                        offsetY6 = InitialPositiony
                                    })
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playingcardniwa6),
                                contentDescription = "cards",
                                contentScale = ContentScale.Crop, alignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(0.dp))
                            )
                        }


                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 30.dp)
                            .padding(4.dp)
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
                                .fillMaxWidth()
                                .height(30.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(8.dp))
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

                            drawPath(waterPath, virtual_plant_sheetcolor)


                        }
                        Spacer(modifier = Modifier.size(6.dp))

                    }
                }


            }

            //PLant 2
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    if (isOnFightPressed) {
//                        Image(
//                            painter = painterResource(id = R.drawable.p32),
//                            contentDescription = "playarea",
//                            modifier = Modifier
//                                .weight(3f)
//                                .size(80.dp)
//                                .clip(RoundedCornerShape(24.dp)), colorFilter = ColorFilter.tint(
//                                virtual_plant_background8
//                            ), alignment = Alignment.CenterStart
//                        )
//
//                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.p32),
                            contentDescription = "playarea",
                            modifier = Modifier
                                .weight(3f)
                                .size(80.dp)

                                .clip(RoundedCornerShape(24.dp)),
                        )
//                    }
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
                            .height(50.dp)
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

                                drawPath(waterPath, virtual_plant_sheetcolor)


                            }
                            Spacer(modifier = Modifier.size(6.dp))

                        }


                    }


                }


            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBattleScreen() {
    var isOnVisible by remember {
        mutableStateOf(false)
    }
    var AttackingPlant by remember {
        mutableStateOf("Fight")
    }
    var onFightPressed by remember {
        mutableStateOf(false)
    }
    var onTotalAmountPlant1 by remember {
        mutableStateOf(400)
    }
    var onUsedAmountPlant1 by remember {
        mutableStateOf(0)
    }
    var onTotalAmountPlant2 by remember {
        mutableStateOf(400)
    }
    var onUsedAmountPlant2 by remember {
        mutableStateOf(0)
    }
    var ticks by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while(true) {
            delay(1.seconds)
            ticks+=30
        }
    }

    if (onUsedAmountPlant1 >= onTotalAmountPlant1) {
        isOnVisible = true
    }
    if (onUsedAmountPlant2 >= onTotalAmountPlant2) {
        isOnVisible = true
    }
    BattleScreen(
        PaddingValues(120.dp),
        onGameResult = {},
        onFight = {
            onFightPressed = it
        },
        onAttack = {
            AttackingPlant = it
        },
        onUsedAmountPlant1 = {
            onUsedAmountPlant1 += it
        },
        isOnFightPressed = onFightPressed,
        isOnAttackingPlant = AttackingPlant,
        isOnVisible = isOnVisible,
        totalHealthAmountPlant1 = onTotalAmountPlant1,
        usedHealthAmountPlant1 = onUsedAmountPlant1,
        onVisible = {
            isOnVisible = it
        },
        onUsedAmountPlant2 = {},
        usedHealthAmountPlant2 = ticks,
        totalHealthAmountPlant2 = onTotalAmountPlant2

    )

}