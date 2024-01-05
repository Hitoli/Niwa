package com.example.virtual_plant_pet.Presentation.screen.HomeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StartFightScreen(modifier:Modifier= Modifier,onFightFind:()->Unit) {
    val composition by  rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.searchingniwaanimation))

    LaunchedEffect(key1 = Unit){
        delay(2000)
        onFightFind()
    }

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
    ){
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
                .width(300.dp)
                .height(300.dp)
                .clip(
                    RoundedCornerShape(24.dp)
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
        ){
            Text(
                text = "Searching...",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier=Modifier.fillMaxWidth().padding(10.dp)
            )

            LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever, modifier = Modifier.size(300.dp))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartFightScreen() {
    StartFightScreen(onFightFind = {})
}