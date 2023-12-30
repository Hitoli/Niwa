package com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundBlackShade
import kotlinx.coroutines.delay

@Composable
fun FirstOnBoardingScreen(onNavigate:()->Unit) {

    var buttonVisibility by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit){
        delay(250)
        buttonVisibility = true
    }
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
        ElevatedCard(
            modifier = Modifier
                .padding(24.dp)
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
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .clip(
                    RoundedCornerShape(
                        16.dp
                    )
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(
                virtual_plant_backgroundBlackShade)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(virtual_plant_backgroundBlackShade)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Welcome To Niwa",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.niwaicon),
                    contentDescription = "solus",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = " • Collect Plants, Nourish them and Expand Your Garden",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = " • Give Plants Soil, Water and Sunshine for uplifting their mood",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = " • Become a Better Gardener, Explorer and showcase your garden to others",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(8.dp))

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
                .padding(16.dp).align(Alignment.BottomCenter)

        ){
            ButtonScreen(
                value = "Ok, Got it",
                onClick = {onNavigate()},
                height = 60.dp,
                width = 300.dp
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFirstOnBoardingScreen() {
    FirstOnBoardingScreen(onNavigate = {})
}