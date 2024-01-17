package com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background8
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundBlackShade
import com.example.virtual_plant_pet.ui.theme.virtual_plant_sheetcolor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SecondOnBoardinScreen(
    modifier: Modifier = Modifier,
    onNavigatie: () -> Unit,
    userName: String,
    usedLoadingAmountPlant: Int,
    LoadingAmountPlant: Int,
    videoTutorialIntro: List<String>,
    videoTutorialIntro2: List<String>,
    getUsedLoadingPlant: (Int) -> Unit,
    visibility:Boolean,
    getVisibility:(Boolean)->Unit,
    buttonVisibility:Boolean,
    getbuttonVisibility:(Boolean)->Unit,
    buttonVisibilityNext:Boolean,
    getbuttonVisibilityNext:(Boolean)->Unit,
    counter:Int,
    getCounter:(Int)->Unit
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.plantonboarding))


    val Loading = animateFloatAsState(
        targetValue = usedLoadingAmountPlant.toFloat() / LoadingAmountPlant.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )
    val coroutineScope = rememberCoroutineScope()



    Box(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(virtual_plant_background3, virtual_plant_background7),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .fillMaxSize()
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .padding(24.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    virtual_plant_backgroundBlackShade.copy(alpha = 0.5f)
                )
                .align(
                    Alignment.Center
                )
        ) {

            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(220.dp)
                    .height(220.dp)
                    .padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
            )



            AnimatedVisibility(
                visible = visibility,
                enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearEasing
                    )
                ),
                exit = fadeOut(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearEasing
                    )
                ), modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.size(40.dp))

                    Text(
                        text = videoTutorialIntro2[counter],
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.size(24.dp))


                    Text(
                        text = videoTutorialIntro[counter],
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center
                    )
                }


            }
            Spacer(modifier = Modifier.size(8.dp))

            Canvas(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.BottomCenter)
            ) {
                val width = size.width
                val height = size.height
                val waterWavesYPosition = (Loading.value) * width
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


        }

        Spacer(modifier = Modifier.size(24.dp))
        AnimatedVisibility(
            visible = buttonVisibilityNext,
            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            ), modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Button(
                onClick = {
                    getVisibility(true)
                    getCounter(1)
                    getUsedLoadingPlant(50)
                          coroutineScope.launch {
                              delay(250)
                              getVisibility(false)
                              delay(250)
                              getVisibility(true)
                          }
                          },
                modifier = Modifier
                    .heightIn(80.dp)
                    .widthIn(80.dp),
                colors = ButtonDefaults.buttonColors(virtual_plant_backgroundBlackShade),
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Outlined.ArrowForwardIos, contentDescription = "", tint = Color.White)
            }

        }
        AnimatedVisibility(
            visible = buttonVisibility,
            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            ), modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            ButtonScreen(
                value = "Ok, Got it",
                onClick = { onNavigatie() },
                height = 60.dp,
                width = 300.dp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondOnBoardinScreen() {
    val videoTutorialIntro = listOf<String>(
        "Welcome, Hitesh",
        "Niwa is your garden",
        "Collect Plants from the wild",
        "Fight other plants to win resources",
        "If somebody Steals your plant, fight for it",
        "Care for your garden, and help your plants grow"
    )
    val videoTutorialIntro2 = listOf<String>(
        "Niwa",
        "Garden",
        "Wild",
        "Fight",
        "Steal",
        "Feed"
    )
    SecondOnBoardinScreen(
        onNavigatie = {},
        userName = "",
        usedLoadingAmountPlant = 0,
        LoadingAmountPlant = 100,
        videoTutorialIntro2 = videoTutorialIntro,
        videoTutorialIntro = videoTutorialIntro2,
        getUsedLoadingPlant = {}, buttonVisibility = false, getVisibility = {}, getbuttonVisibility = {}, visibility = true, counter = 0, getCounter = {}, buttonVisibilityNext = true, getbuttonVisibilityNext = {

        })
}