package com.example.virtual_plant_pet.Presentation.screen.WildScreen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.graphicsLayer
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
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.Presentation.screen.screenmodals.CardFace
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundNight
import com.example.virtual_plant_pet.utils.WavyShape
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

//@Preview(showBackground = true)
@Composable
fun PlantsInTheWildScreen(pad: PaddingValues) {


//    PlantInTheWildOnBoardingAlert()
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val ChallengesList = listOf(
        "Steal a Plant",
        "Feed Water to a Plant"
    )
    val BonusList = listOf(
        "Steal a Plant",
        "Feed Water to a Plant"
    )
    val ExploreList = listOf(
        "Steal a Plant",
        "Feed Water to a Plant"
    )

    val value by rememberInfiniteTransition().animateFloat(
        initialValue = 1.dp.value,
        targetValue = 3.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
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
    val value2 by rememberInfiniteTransition().animateFloat(
        initialValue = 1.dp.value,
        targetValue = 3.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000,
            ),
            repeatMode = RepeatMode.Reverse
        )
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

    var Image1 by remember {
        mutableIntStateOf(0)
    }
    var Image2 by remember {
        mutableIntStateOf(0)
    }
    var Image3 by remember {
        mutableIntStateOf(0)
    }
    var isCaptured1 by remember {
        mutableStateOf(false)
    }
    var isCaptured2 by remember {
        mutableStateOf(false)
    }
    var isCaptured3 by remember {
        mutableStateOf(false)
    }
    var isAddedtoGarden by remember {
        mutableStateOf(false)
    }

    PlantInTheWildCaptureAlert(
        Image1,
        Image2,
        Image3,
        isCaptured1,
        isCaptured2,
        isCaptured3,
        isCaptured = {
            isCaptured2 = it
        })
    if (isCaptured2) {
        isAddedtoGarden = true
    }
    Log.e("iscapr ", Image1.toString())
    Log.e("iscapr ", Image2.toString())
    Log.e("iscapr ", Image3.toString())
    Log.e("iscapr ", isCaptured1.toString())
    Log.e("iscapr ", isCaptured2.toString())
    Log.e("iscapr ", isCaptured3.toString())
    Log.e("iscapr ", isAddedtoGarden.toString())

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.wilk),
            contentDescription = "landscape",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds
        )

        ElevatedCard(
            modifier = Modifier
                .widthIn(50.dp).padding(start = 8.dp)
                .heightIn(50.dp)
                .align(Alignment.CenterStart)
                .clip(
                    CircleShape
                ), colors = CardDefaults.cardColors(virtual_plant_background7)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bonusicon),
                contentDescription = "Plant",
                modifier = Modifier
                    .size(70.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .clickable {
                        isVisible = true

                    },
            )

        }
        if(isVisible){
            PlantInTheWildOptions(ChallengesList = ChallengesList, onIsVisible = {
                isVisible = it
            })
        }




        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
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
                PlantsInTheWildScreenPlantCard(
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
fun PlantsInTheWildScreenPlantCard(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantInTheWildCaptureAlert(
    Image1: Int,
    Image2: Int,
    Image3: Int,
    isCaptured1: Boolean,
    isCaptured2: Boolean,
    isCaptured3: Boolean,
    isCaptured: (Boolean) -> Unit
) {
    var cardFace by remember {
        mutableStateOf(CardFace.Front)
    }
    val coroutine = rememberCoroutineScope()
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


    if (isCaptured1 || isCaptured2 || isCaptured3) {

        AlertDialog(
            onDismissRequest = { isCaptured(false) },
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
                LaunchedEffect(key1 = isCaptured1 || isCaptured2 || isCaptured3) {
                    delay(600)
                    cardFace = cardFace.next

                }
                PlantInTheWildPlantFlipCard(
                    cardFace = cardFace,
                    Mood = "Captured",
                    Image = Image2
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "You have Captured Spendelite",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))

                ButtonScreen(
                    value = "Add to Garden",
                    onClick = { isCaptured(false) },
                    height = 60.dp,
                    width = 300.dp
                )
            }

        }
    }
}

@Composable
fun PlantInTheWildPlantFlipCard(
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
            .width(100.dp)
            .height(100.dp)
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
                    PlantInTheWildPlantCard(Image)
                }
            } else {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { rotationY = 180f }) {
                    PlantInTheWildPlantCard2(Mood)
                }
            }

        }
    }
}

@Composable
fun PlantInTheWildPlantCard(Image: Int) {
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

@Composable
fun PlantInTheWildPlantCard2(Mood: String) {
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
                    fontSize = 12.sp, color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Default
                )
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantInTheWildOptions(ChallengesList:List<String>,onIsVisible:(Boolean)->Unit) {

        AlertDialog(
            onDismissRequest = { onIsVisible(false) },
            properties = DialogProperties(true, true),
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
                    .padding(30.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ElevatedCard(
                    modifier = Modifier
                        .size(width = 300.dp, height = 200.dp)
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Gray,
                            shape = RoundedCornerShape(
                                16.dp
                            )
                        )
                        .border(
                            border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                                16.dp
                            )
                        )
                        .clip(
                            RoundedCornerShape(
                                16.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .size(width = 300.dp, height = 200.dp)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Challenges",
                            modifier = Modifier,
                            fontSize = 30.sp, color = Color.Black,
                            fontWeight = FontWeight.Light,
                            fontFamily = FontFamily.Default
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        LazyColumn(){
                            items(ChallengesList){
                                Text(
                                    text = it,
                                    modifier = Modifier,
                                    fontSize = 18.sp, color = Color.Black,
                                    fontWeight = FontWeight.Light,
                                    fontFamily = FontFamily.Default,
                                    textAlign = TextAlign.Start
                                )
                            }
                        }


                    }
                }
                ElevatedCard(
                    modifier = Modifier
                        .size(width = 300.dp, height = 200.dp)
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Gray,
                            shape = RoundedCornerShape(
                                16.dp
                            )
                        )
                        .border(
                            border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                                16.dp
                            )
                        )
                        .clip(
                            RoundedCornerShape(
                                16.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .size(width = 300.dp, height = 200.dp)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Explore",
                            modifier = Modifier,
                            fontSize = 30.sp, color = Color.Black,
                            fontWeight = FontWeight.Light,
                            fontFamily = FontFamily.Default
                        )
                        Spacer(modifier = Modifier.size(10.dp))

                        LazyColumn(){
                            items(ChallengesList){
                                Text(
                                    text = it,
                                    modifier = Modifier,
                                    fontSize = 18.sp, color = Color.Black,
                                    fontWeight = FontWeight.Light,
                                    fontFamily = FontFamily.Default,
                                    textAlign = TextAlign.Start
                                )
                            }
                        }

                    }
                }
                ElevatedCard(
                    modifier = Modifier
                        .size(width = 300.dp, height = 200.dp)
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Gray,
                            shape = RoundedCornerShape(
                                16.dp
                            )
                        )
                        .border(
                            border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                                16.dp
                            )
                        )
                        .clip(
                            RoundedCornerShape(
                                16.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .size(width = 300.dp, height = 200.dp)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Bonus",
                            modifier = Modifier,
                            fontSize = 30.sp, color = Color.Black,
                            fontWeight = FontWeight.Light,
                            fontFamily = FontFamily.Default
                        )
                        Spacer(modifier = Modifier.size(10.dp))

                        LazyColumn(){
                            items(ChallengesList){
                                Text(
                                    text = it,
                                    modifier = Modifier,
                                    fontSize = 18.sp, color = Color.Black,
                                    fontWeight = FontWeight.Light,
                                    fontFamily = FontFamily.Default,
                                    textAlign = TextAlign.Start
                                )
                            }
                        }

                    }
                }
            }

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