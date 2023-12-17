package com.example.virtual_plant_pet.screen

import android.view.Gravity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.navigation.VirtualPlantScreenResourcesIndicator
import com.example.virtual_plant_pet.screenmodals.CardFace
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background4
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background5
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundNight
import com.example.virtual_plant_pet.ui.theme.virtual_plant_sheetcatalogcolor
import com.example.virtual_plant_pet.ui.theme.virtual_plant_sheetcolor
import com.example.virtual_plant_pet.ui.theme.virual_plant_background1
import com.example.virtual_plant_pet.ui.theme.virual_plant_background2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VirtualPlantScreen(modifier: Modifier = Modifier, pad: PaddingValues) {
    VirtualPlantScreenOnBoardingAlert()
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )


    var cardFace by remember {
        mutableStateOf(CardFace.Front)
    }
    var onFeeeding by remember {
        mutableStateOf(false)
    }

    val snackbarhost = remember {
        SnackbarHostState()
    }

    var isVisible by remember {
        mutableStateOf(false)
    }
    var isVisible2 by remember {
        mutableStateOf(false)
    }
    var isVisible3 by remember {
        mutableStateOf(false)
    }
    var isDismiss by remember {
        mutableStateOf(false)
    }
    var watervalue by remember{
        mutableStateOf(10)
    }
    var soilvalue by remember{
        mutableStateOf(10)
    }
    var sunlightvalue by remember{
        mutableStateOf(10)
    }

    val coroutineScope = rememberCoroutineScope()

    val goodMoods = listOf<String>(
        "Dancing in the gentle breeze 🍃",
        "Radiant and flourishing! 🌸",
        "Thriving in the garden of happiness 🌼",
        "Enjoying a day in bloom 🌺",
        "Living my best green life! 🌿",
        "Feeling the love from nature's embrace 🌞",
        "Swaying with joy in the sunlight 🎶",
        "Sprouting happiness every day! 🌻",
        "Glowing with positivity ✨",
        "Soaking up good vibes like sunshine ☀️"
    )
    val badMoods = listOf<String>(
        "Feeling a bit wilted and weary 😔",
        "Cloudy days in my garden ☁️🌧️",
        "Drooping with a touch of sadness 🥀",
        "In need of a little pick-me-up 🚿",
        "Weathering a storm of emotions ⛈️",
        "Wilted leaves, wilting spirits 😢",
        "Craving a splash of life 💦",
        "Longing for some sunshine in my day ☁️",
        "Struggling to find my bloom 🌱",
        "Feeling a bit under the weather 🌧️"
    )
    val neutralMoods = listOf<String>(
        "Enjoying a quiet day in the garden 🌳",
        "Calm and collected in my green haven 🌿",
        "Resting peacefully among the leaves 🍃",
        "Serenity in simplicity 🌱",
        "A tranquil moment in the plant life cycle 🌼",
        "Balanced and composed in the natural rhythm 🎶",
        "Gentle sways in the breeze, at peace 🌬️",
        "Harmony in every leaf and petal 🌸",
        "A day of quiet growth and reflection 🌳",
        "Content with the ebb and flow of life 🍂"
    )

//    val startColor =  Brush.linearGradient(
//        colors = listOf(virtual_plant_background, virual_plant_background2),
//        start = Offset(Float.POSITIVE_INFINITY, 0f),
//        end = Offset(0f, Float.POSITIVE_INFINITY)
//    )
//    val endColor = Brush.linearGradient(
//        colors = listOf(virtual_plant_background, virual_plant_background2),
//        start = Offset(Float.POSITIVE_INFINITY, 0f),
//        end = Offset(0f, Float.POSITIVE_INFINITY)
//    )

    // Use animateColorAsState to create an animated color value
//    val animatedColor: Brush by animateColorAsState(
//        targetValue = if (isVisible) endColor else startColor,
//        animationSpec = tween(durationMillis = 5000)
//    )

    val SheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            initialValue = SheetValue.Hidden,
            skipPartiallyExpanded = true,
            skipHiddenState = false
        )
    )
    BottomSheetScaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarhost
            ) {
                ElevatedCard(
                    modifier = Modifier
                        .offset(y = -75.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                        .padding(16.dp)
                        .clip(
                            RoundedCornerShape(
                                8.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.Black)
                ) {
                    Text(
                        text = "  \uD83C\uDF38  " + it.visuals.message,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 18.sp, color = Color.White,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Default,
                        textAlign = TextAlign.Center
                    )
                }

            }

        },
        sheetContent = {
            VirtualPlantScreenSheetContent(pad)
        },
        scaffoldState = SheetState,
        sheetSwipeEnabled = true,
        containerColor = virtual_plant_background.copy(alpha = 0.3f),
        sheetContainerColor = virtual_plant_background.copy(alpha = 0.5f),
        sheetDragHandle = {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "DragHandle",
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 16.dp),
                tint = Color.Black
            )
        }) {
        Box(
            modifier = modifier.background(
                Brush.linearGradient(
                    colors = listOf(virtual_plant_background, virtual_plant_background3),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                ) {

                    VirtualPlantScreenPlantFlipCard(
                        cardFace = if (isVisible || isVisible2 || isVisible3) cardFace.next else cardFace,
                        Mood = if (isVisible) goodMoods.get(1) else badMoods.get(1),
                        R.drawable.p6
                    )


//                    VirtualPlantScreenFeedIndicator(
//                        modifier = Modifier
//                            .size(400.dp)
//                            .padding(20.dp, bottom = 30.dp), feedIndicator
//                    )

                }

                ElevatedCard(
                    modifier = Modifier
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Gray,
                            shape = RoundedCornerShape(
                                topEnd = 62.dp,
                                topStart = 62.dp,
                                bottomEnd = 0.dp,
                                bottomStart = 0.dp
                            )
                        )
                        .border(
                            border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                                topEnd = 62.dp,
                                topStart = 62.dp,
                                bottomEnd = 0.dp,
                                bottomStart = 0.dp
                            )
                        )
                        .fillMaxWidth()
                        .fillMaxHeight(1f)
                        .clip(
                            RoundedCornerShape(
                                topEnd = 62.dp,
                                topStart = 62.dp,
                                bottomEnd = 0.dp,
                                bottomStart = 0.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxSize()
                            .padding(bottom = pad.calculateBottomPadding()),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            coroutineScope.launch {
                                                SheetState.bottomSheetState.expand()
                                            }
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.plant),
                                        contentDescription = "Plant",
                                        modifier = Modifier.size(25.dp), tint = Color.Black
                                    )
                                    Spacer(modifier = Modifier.size(4.dp))
                                    Text(
                                        text = "Your Pet Plant",
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 25.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.SansSerif,
                                        textAlign = TextAlign.Start
                                    )
                                }

                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "Petalia",
                                    modifier = Modifier
                                        .clickable {
                                            coroutineScope.launch {
                                                SheetState.bottomSheetState.expand()
                                            }
                                        }
                                        .fillMaxWidth()
                                        .padding(start = 30.dp),
                                    fontSize = 18.sp, color = Color.Black,
                                    fontWeight = FontWeight.Light,
                                    fontFamily = FontFamily.Default, textAlign = TextAlign.Start
                                )
                            }
                            Spacer(modifier = Modifier.size(16.dp))

                            Column {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            isDismiss = true
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.plantmood),
                                        contentDescription = "Plant", tint = Color.Black,
                                        modifier = Modifier.size(25.dp)
                                    )
                                    Spacer(modifier = Modifier.size(4.dp))
                                    Text(
                                        text = "Plant's Mood",
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 25.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.SansSerif,
                                        textAlign = TextAlign.Start
                                    )
                                }
                                VirtualPlantScreenOnMoodIntro(isDismiss, onDismiss = {
                                    isDismiss = it
                                })

                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "Happy :)",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 30.dp),
                                    fontSize = 18.sp, color = Color.Black,
                                    fontWeight = FontWeight.Light,
                                    fontFamily = FontFamily.Default, textAlign = TextAlign.Start
                                )
                            }

                        }
                        Text(
                            text = "Select Nutrition",
                            fontSize = 18.sp, color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif, textAlign = TextAlign.Start
                        )
                        Row {
                            VirtualPlantScreenFeedCard(
                                isVisible = isVisible,
                                onClickVisible = {
                                    isVisible = it
                                },
                                Feed = "Water",
                                FeedImage = R.drawable.water,
                                snackbarhost = snackbarhost, onFeed = {

                                    onFeeeding = it
                                }, onColor = {
                                    virtual_plant_background
                                }
                            )

                            if (isVisible){
                                watervalue+=10
                            }
                            if (isVisible2){
                                soilvalue+=10
                            }
                            if (isVisible3){
                                sunlightvalue+=10
                            }
                            AppNavMapIndicatorAlertBoxWater(isVisible = isVisible, onIsVisible = {
                                isVisible = it
                            },watervalue,120)
                            AppNavMapIndicatorAlertBoxSoil(isVisible = isVisible2, onIsVisible = {
                                isVisible2 = it
                            },soilvalue,120)
                            AppNavMapIndicatorAlertBoxSolar(isVisible = isVisible3, onIsVisible = {
                                isVisible3 = it
                            },sunlightvalue,120)
                            Spacer(modifier = Modifier.size(2.dp))

                            VirtualPlantScreenFeedCard(isVisible2, onClickVisible = {
                                isVisible2 = it
                            }, "Nutrients", R.drawable.soilnutrients, snackbarhost, onFeed = {

                                onFeeeding = it
                            }, onColor = {
                                virtual_plant_background4
                            })

                            Spacer(modifier = Modifier.size(2.dp))
                            VirtualPlantScreenFeedCard(
                                isVisible = isVisible3,
                                onClickVisible = {
                                    isVisible3 = it

                                },
                                Feed = "Sunshine",
                                FeedImage = R.drawable.sunshine, snackbarhost, onFeed = {

                                    onFeeeding = it
                                }, onColor = {
                                    virtual_plant_background5
                                }
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    coroutineScope.launch {
                                        SheetState.bottomSheetState.expand()
                                    }
                                },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "Learn More About Your Pet", color = Color.Black,
                                fontSize = 15.sp,
                                modifier = Modifier,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif, textAlign = TextAlign.Start
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowRight,
                                contentDescription = "learnMore",
                                tint = Color.Black
                            )
                        }


                    }
                }
            }


        }
    }
}




//@Preview(showBackground = true)
@Composable
fun VirtualPlantScreenSheetContent(pad: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(
                Color.White,
                RoundedCornerShape(16.dp)
            )
            .padding(bottom = pad.calculateBottomPadding()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Your Petalia",
            modifier = Modifier.padding(8.dp),
            fontSize = 24.sp, color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default
        )
        Spacer(modifier = Modifier.size(15.dp))
        Row {
            Text(
                text = "Water Intake:",
                modifier = Modifier.padding(8.dp),
                fontSize = 15.sp, color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "400ml",
                modifier = Modifier.padding(8.dp),
                fontSize = 15.sp, color = Color.Black,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Default
            )
        }
        Row {
            Text(
                text = "Soil Type:",
                modifier = Modifier.padding(8.dp),
                fontSize = 15.sp, color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "Sandy loam soil",
                modifier = Modifier.padding(8.dp),
                fontSize = 15.sp, color = Color.Black,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Default
            )
        }


        Text(
            text = "About Your Plants:",
            modifier = Modifier.padding(8.dp),
            fontSize = 20.sp, color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default
        )
        Spacer(modifier = Modifier.size(15.dp))
        Text(
            text = "Watermelon is grown in favorable climates from tropical to temperate regions worldwide for its large edible fruit, which is a berry with a hard rind and no internal divisions, and is botanically called a pepo. The sweet, juicy flesh is usually deep red to pink, with many black seeds, although seedless varieties exist. The fruit can be eaten raw or pickled, and the rind is edible after cooking. It may also be consumed as a juice or an ingredient in mixed beverages.",
            modifier = Modifier.padding(8.dp),
            fontSize = 15.sp, color = Color.Black,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.Default
        )


    }
}

@Composable
fun VirtualPlantScreenPlantCard(Image:Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        ElevatedCard(
            modifier = Modifier
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color.Gray,
                    shape = RoundedCornerShape(24.dp)
                )
                .border(
                    border = BorderStroke(0.2.dp, Color.Gray),
                    shape = RoundedCornerShape(24.dp)
                )
                .widthIn(200.dp)
                .heightIn(200.dp)
                .clip(
                    RoundedCornerShape(24.dp)
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
        ) {
            Image(
                painter = painterResource(id = Image),
                contentDescription = "petplantname",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavMapIndicatorAlertBoxWater(isVisible: Boolean, onIsVisible: (Boolean) -> Unit,usedWaterAmount:Int,totalWaterAmount: Int) {

    val waterPercentage = animateFloatAsState(targetValue = usedWaterAmount.toFloat()/totalWaterAmount.toFloat(), label = "water", animationSpec = tween(durationMillis = 1000))


    if (isVisible) {
        AlertDialog(
            onDismissRequest = { onIsVisible(false) },
            properties = DialogProperties(false, false),
            modifier = Modifier.width(110.dp)
                .fillMaxHeight(0.2f).padding(top=10.dp, end = 10.dp, start = 10.dp)
                .clip(
                    RoundedCornerShape(24.dp)
                )) {
            val view = (LocalView.current.parent as DialogWindowProvider)
            view.window.setGravity(Gravity.END)
            view.window.setDimAmount(0f)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Canvas(modifier = Modifier.width(100.dp).height(100.dp)) {
                            val width = size.width
                            val height= size.height
                            val waterWavesYPosition =(1 - waterPercentage.value)*height
                            val waterPath = Path().apply {
                                moveTo(
                                    x = 0f,
                                    y=waterWavesYPosition
                                )
                                lineTo(
                                    x = width,
                                    y=waterWavesYPosition
                                )
                                lineTo(
                                    x=width,
                                    y=height
                                )
                                lineTo(
                                    x = 0f,
                                    y = height
                                )
                                close()
                            }

                            drawPath(waterPath, virtual_plant_background3)



                        }
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = "Water",
                            color = Color.White,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }


                }
            }


        }


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavMapIndicatorAlertBoxSoil(isVisible: Boolean, onIsVisible: (Boolean) -> Unit,usedSoilAmount:Int,totalSoilAmount: Int) {

    val soilPercentage = animateFloatAsState(targetValue = usedSoilAmount.toFloat()/totalSoilAmount.toFloat(), label = "water", animationSpec = tween(durationMillis = 1000))

    if (isVisible) {
        AlertDialog(
            onDismissRequest = { onIsVisible(false) },
            properties = DialogProperties(false, false),
            modifier = Modifier.width(110.dp)
                .fillMaxHeight(0.2f).padding(top=10.dp, end = 10.dp, start = 10.dp)
                .clip(
                    RoundedCornerShape(24.dp)
                )) {
            val view = (LocalView.current.parent as DialogWindowProvider)
            view.window.setGravity(Gravity.END)
            view.window.setDimAmount(0f)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {



                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Canvas(modifier = Modifier.width(100.dp).height(100.dp)) {
                            val width = size.width
                            val height= size.height
                            val waterWavesYPosition =(1 - soilPercentage.value)*height
                            val waterPath = Path().apply {
                                moveTo(
                                    x = 0f,
                                    y=waterWavesYPosition
                                )
                                lineTo(
                                    x = width,
                                    y=waterWavesYPosition
                                )
                                lineTo(
                                    x=width,
                                    y=height
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


                }



        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavMapIndicatorAlertBoxSolar(isVisible: Boolean, onIsVisible: (Boolean) -> Unit,usedSolarAmount:Int,totalSolarAmount: Int) {

    val solarPercentage = animateFloatAsState(targetValue = usedSolarAmount.toFloat()/totalSolarAmount.toFloat(), label = "water", animationSpec = tween(durationMillis = 1000))

    if (isVisible) {
        AlertDialog(
            onDismissRequest = { onIsVisible(false) },
            properties = DialogProperties(false, false),
            modifier = Modifier.width(110.dp)
                .fillMaxHeight(0.2f).padding(top=10.dp, end = 10.dp, start = 10.dp)
                .clip(
                    RoundedCornerShape(24.dp)
                )) {
            val view = (LocalView.current.parent as DialogWindowProvider)
            view.window.setGravity(Gravity.END)
            view.window.setDimAmount(0f)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Canvas(modifier = Modifier.width(100.dp).height(100.dp)) {
                            val width = size.width
                            val height= size.height
                            val waterWavesYPosition =(1 - solarPercentage.value)*height
                            val waterPath = Path().apply {
                                moveTo(
                                    x = 0f,
                                    y=waterWavesYPosition
                                )
                                lineTo(
                                    x = width,
                                    y=waterWavesYPosition
                                )
                                lineTo(
                                    x=width,
                                    y=height
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
fun VirtualPlantScreenPlantCard2(Mood: String) {
    val mood by remember {
        mutableStateOf(Mood)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        ElevatedCard(
            modifier = Modifier
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color.Gray,
                    shape = RoundedCornerShape(24.dp)
                )
                .border(
                    border = BorderStroke(0.2.dp, Color.Gray),
                    shape = RoundedCornerShape(24.dp)
                )
                .widthIn(200.dp)
                .heightIn(200.dp)
                .clip(
                    RoundedCornerShape(24.dp)
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = mood,
                    modifier = Modifier.padding(24.dp),
                    fontSize = 18.sp, color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Default
                )
            }


        }
    }
}

@Composable
fun VirtualPlantScreenPlantFlipCard(
    cardFace: CardFace,
    Mood: String,
    Image: Int
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(
            durationMillis = 1800,
            easing = FastOutSlowInEasing,
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {


        Card(modifier = Modifier
            .size(200.dp)
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 12f * density
            }
            .shadow(
                elevation = 10.dp,
                spotColor = Color.Gray,
                shape = RoundedCornerShape(24.dp)
            )
            .border(
                border = BorderStroke(0.2.dp, Color.Gray),
                shape = RoundedCornerShape(24.dp)
            )
            .clip(
                RoundedCornerShape(24.dp)
            )
            .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)

        ) {
            if (rotation.value <= 90f) {
                Box(modifier = Modifier.fillMaxSize()) {
                    VirtualPlantScreenPlantCard(Image)
                }
            } else {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { rotationY = 180f }) {
                    VirtualPlantScreenPlantCard2(Mood)
                }
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VirtualPlantScreenFeedCard(
    isVisible: Boolean,
    onClickVisible: (Boolean) -> Unit,
    Feed: String,
    FeedImage: Int,
    snackbarhost: SnackbarHostState,
    onFeed: (Boolean) -> Unit,
    onColor:()->Color,
) {
    val coroutineScope = rememberCoroutineScope()
    var colorOfButton by remember{
        mutableStateOf(false)
    }


    ElevatedCard(
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color.Gray,
                shape = RoundedCornerShape(24.dp)
            )
            .combinedClickable(
                onClick = {
                    coroutineScope.launch {
                        snackbarhost.showSnackbar("Please Give $Feed patiently")
                    }
                },
                onLongClick = {
                    onFeed(true)
                    onClickVisible(true)
                    colorOfButton = true
                    coroutineScope.launch {
                        delay(5000)
                        onClickVisible(false)
                        onFeed(false)
                        colorOfButton = false
                    }


                }
            )
            .width(100.dp)
            .height(100.dp)
            .clip(
                RoundedCornerShape(24.dp)
            ), colors = CardDefaults.cardColors(if (!colorOfButton)Color.Black else onColor())
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = isVisible,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut()
            ) {

                Text(
                    text = Feed,
                    color = if (!colorOfButton)Color.White else Color.Black,
                    modifier = Modifier
                        .padding(6.dp)
                )


            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(id = FeedImage),
                contentDescription = "Plant",
                modifier = Modifier
                    .size(30.dp), tint =if (!colorOfButton)Color.White else Color.Black
            )


        }


    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VirtualPlantScreenOnBoardingAlert() {

    var dismiss by remember {
        mutableStateOf(true)
    }

    if (dismiss) {
        AlertDialog(
            onDismissRequest = { }, properties = DialogProperties(false, false), modifier = Modifier
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
                    text = "Welcome To Plant Care Center",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Take care of your plants by providing water, soil and sunshine",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "It will reflect in the plant's Mood",
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VirtualPlantScreenOnMoodIntro(dismiss:Boolean,onDismiss:(Boolean)->Unit) {



    if (dismiss) {
        AlertDialog(
            onDismissRequest = { }, properties = DialogProperties(false, false), modifier = Modifier
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
                    text = "Take care of your Plant",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Take care of your plants by providing water, soil and sunlight",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "It will reflect in the plant's Mood",
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
                    onClick = { onDismiss(false) },
                    height = 60.dp,
                    width = 300.dp
                )
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun VirtualPlantScreenPreview() {

//    VirtualPlantScreenOnBoardingAlert()

    VirtualPlantScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(virtual_plant_background), PaddingValues(10.dp)
    )
}