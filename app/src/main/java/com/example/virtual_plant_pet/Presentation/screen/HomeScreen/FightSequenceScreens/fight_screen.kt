package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
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
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.solus.authScreens.authUtils.MyCircle
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background8
import com.example.virtual_plant_pet.ui.theme.virtual_plant_sheetcolor
import com.example.virtual_plant_pet.Presentation.screen.screenmodals.PlantAttacks
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FightScreen(
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


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp)
                .align(Alignment.TopCenter)
                .padding(bottom = 80.dp, top = 40.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 10.dp, top = 10.dp)
                    .height(200.dp)
            ) {
                Column(
                    modifier = Modifier, verticalArrangement = Arrangement.SpaceEvenly,
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
                            .widthIn(150.dp)
                            .height(70.dp)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            ), colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Text(
                            text = "Blum",
                            color = Color.Black,
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .width(150.dp), textAlign = TextAlign.Center
                        )

                        Row(
                            modifier = Modifier
                                .width(150.dp)
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
                                    .width(150.dp)
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


                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.p35),
                    contentDescription = "playarea",
                    modifier = Modifier
                        .weight(3f)
                        .size(100.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .offset(
                            x = if (isOnFightPressed) value.dp else 0.dp
                        )
                )
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(100.dp)
                        .weight(4f)
                ) {
                    if (isOnFightPressed) {
                        LottieAnimation(
                            composition = composition, modifier = Modifier
                                .size(500.dp)

                        )
                    }
                }


                if (isOnFightPressed) {
                    Image(
                        painter = painterResource(id = R.drawable.p31),
                        contentDescription = "playarea",
                        modifier = Modifier
                            .weight(3f)
                            .size(100.dp)
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
                            .size(100.dp)

                            .clip(RoundedCornerShape(24.dp)),
                    )
                }
            }



            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, top = 10.dp)
                    .height(200.dp)
            ) {


                ElevatedCard(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
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
                        .widthIn(150.dp)
                        .height(70.dp)
                        .clip(
                            RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {
                    Text(
                        text = "Mystique",
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .width(150.dp), textAlign = TextAlign.Center
                    )



                    Row(
                        modifier = Modifier
                            .width(150.dp)
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
                                .width(150.dp)
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

        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment =
            Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .size(100.dp, 150.dp)
                .border(
                    BorderStroke(1.dp, Color.Black),
                    RoundedCornerShape(16.dp)
                )
                .onGloballyPositioned { coordinates ->
                    InitialPositionx = 0f
                    InitialPositiony = -coordinates.positionInRoot().y + 230f
                    Log.e("InitialPositiony", InitialPositiony.toString())
                    Log.e("InitialPositionx", InitialPositionx.toString())
                })
            Spacer(modifier = Modifier.size(8.dp))

            Box(modifier = Modifier
                .size(100.dp, 150.dp)
                .border(
                    BorderStroke(1.dp, Color.Black),
                    RoundedCornerShape(16.dp)
                )
                .onGloballyPositioned { coordinates ->
                    InitialPositionx = 0f
                    InitialPositiony = -coordinates.positionInRoot().y + 230f
                    Log.e("InitialPositiony", InitialPositiony.toString())
                    Log.e("InitialPositionx", InitialPositionx.toString())
                })
            Spacer(modifier = Modifier.size(8.dp))

            Box(modifier = Modifier
                .size(100.dp, 150.dp)
                .border(
                    BorderStroke(1.dp, Color.Black),
                    RoundedCornerShape(16.dp)
                )
                .onGloballyPositioned { coordinates ->
                    InitialPositionx = 0f
                    InitialPositiony = -coordinates.positionInRoot().y + 230f
                    Log.e("InitialPositiony", InitialPositiony.toString())
                    Log.e("InitialPositionx", InitialPositionx.toString())
                })
        }



        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(300.dp)
                .padding(10.dp)
                .background(
                    Color.White.copy(alpha = 0.5f), RoundedCornerShape(24.dp)
                )

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier
                        .offset { IntOffset(offsetXdrag.value, offsetYdrag.value) }
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .size(100.dp, 150.dp)
                        .pointerInput(Unit) {
                            detectDragGestures(onDrag = { change, dragAmount ->
                                change.consume()
                                dragging = change.pressed
                                Log.e("dragginf", change.pressed.toString())
                                offsetX += dragAmount.x
                                offsetY += dragAmount.y
                            }, onDragEnd = {
                                offsetX = InitialPositionx
                                offsetY = InitialPositiony
                            })
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cards2),
                        contentDescription = "cards",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp))
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
                Box(
                    Modifier
                        .offset { IntOffset(offsetXdrag2.value, offsetYdrag2.value) }
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .size(100.dp, 150.dp)
                        .pointerInput(Unit) {
                            detectDragGestures(onDrag = { change, dragAmount ->
                                change.consume()
                                dragging2 = change.pressed
                                Log.e("dragginf", change.pressed.toString())
                                offsetX2 += dragAmount.x
                                offsetY2 += dragAmount.y
                            }, onDragEnd = {
                                offsetX2 = InitialPositionx
                                offsetY2 = InitialPositiony
                            })
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cards3),
                        contentDescription = "cards",
                        contentScale = ContentScale.Crop, alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp))
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))

                Box(
                    Modifier
                        .offset { IntOffset(offsetXdrag3.value, offsetYdrag3.value) }
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .size(100.dp, 150.dp)
                        .pointerInput(Unit) {
                            detectDragGestures(onDrag = { change, dragAmount ->
                                change.consume()
                                dragging3 = change.pressed
                                Log.e("dragginf", change.pressed.toString())
                                offsetX3 += dragAmount.x
                                offsetY3 += dragAmount.y
                            }, onDragEnd = {
                                offsetX3 = InitialPositionx
                                offsetY3 = InitialPositiony
                            })
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cards),
                        contentDescription = "cards",
                        contentScale = ContentScale.Crop, alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp))
                    )
                }
            }


        }

    }


    FightScreenGameResult(isOnVisible, onVisible = {
        onVisible(it)
    }, onDone = {
        onGameResult()
    })


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FightScreenGameResult(onIsVisible: Boolean, onVisible: (Boolean) -> Unit, onDone: () -> Unit) {
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
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "You Win",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.p33),
                    contentDescription = "playarea",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(24.dp))

                )
                Row {
                    Text(
                        text = "XP",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "+2000",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                }

                Row {
                    Text(
                        text = "Plant Level",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "+1",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = {
                        onVisible(false)
                        onDone()
                    },
                    modifier = Modifier
                        .heightIn(65.dp)
                        .widthIn(150.dp)
                        .padding(10.dp)
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Done",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = fontFamily
                    )
                }


            }


        }
    }

}


@Preview(showBackground = true)
@Composable
fun FightScreenPreview() {
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

    if (onUsedAmountPlant1 >= onTotalAmountPlant1) {
        isOnVisible = true
    }
    if (onUsedAmountPlant2 >= onTotalAmountPlant2) {
        isOnVisible = true
    }
    FightScreen(
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
        usedHealthAmountPlant2 = onUsedAmountPlant2,
        totalHealthAmountPlant2 = onTotalAmountPlant2

    )
}