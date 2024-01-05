package com.example.virtual_plant_pet.Presentation.screen.AuthScreens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen2
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.TextScreen
import com.example.virtual_plant_pet.R

import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun ButtonPrecview2() {
    SignIn(onLogin={}, onSignIn={})
}

@Composable
fun SignIn(onLogin:()->Unit, onSignIn:()->Unit) {

    var visible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit ){
        delay(1200)
        visible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(virtual_plant_background, virtual_plant_background3),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.niwaicon),
                contentDescription = "solus",
                modifier = Modifier.size(200.dp).clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.size(28.dp))
            TextScreen("Your Garden", 20)
            Spacer(modifier = Modifier.size(28.dp))
            AnimatedVisibility(visible = visible) {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    ButtonScreen(value = "Login", onClick = onLogin, height = 60.dp, width = 300.dp)
                    Spacer(modifier = Modifier.size(28.dp))
                    ButtonScreen2(value = "Sign Up", onClick = onSignIn)
                }
            }


        }
    }
}