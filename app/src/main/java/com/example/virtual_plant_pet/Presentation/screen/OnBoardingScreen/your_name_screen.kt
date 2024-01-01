package com.example.virtual_plant_pet.Presentation.screen.OnBoardingScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background8
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundBlackShade

@Preview(showBackground = true)
@Composable
fun YourNameScreenPreview() {
    YourNameScreen(onNavigate = {},"", getUserName = {},empty = true)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourNameScreen(onNavigate:()->Unit, userName:String, getUserName:(String)->Unit, empty:Boolean) {

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
                .padding(16.dp)
//                .shadow(
//                    elevation = 10.dp,
//                    spotColor = Color.Gray,
//                    shape = RoundedCornerShape(
//                        16.dp
//                    )
//                )
                .border(
                    border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                        16.dp
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight(.31f)
                .clip(
                    RoundedCornerShape(
                        16.dp
                    )
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(
                virtual_plant_backgroundBlackShade.copy(alpha = 0.5f)), elevation = CardDefaults.cardElevation(0.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.size(5.dp))


                Text(
                    text = "What is your Name?",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(5.dp))

                OutlinedTextField(
                    value = userName,
                    onValueChange = {
                        getUserName(it)

                    },
                    Modifier
                        .widthIn(300.dp)
                        .heightIn(60.dp)
                        .background(
                            Color.Transparent
                        ),
                    label = {
                        Text(text = "Your Name...", color = Color.White.copy(alpha = 0.6f))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color.White, unfocusedBorderColor = Color.White, focusedContainerColor =  virtual_plant_backgroundBlackShade.copy(alpha = 0.8f)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "UserName",
                            tint = Color.White
                        )
                    })
                AnimatedVisibility(
                    visible = empty,
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

                ){
                    Text(
                        text = "Please Enter your name...",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 10.sp,
                        color = virtual_plant_background8,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.size(12.dp))
                Button(
                    onClick = { onNavigate() },
                    modifier = Modifier
                        .heightIn(60.dp)
                        .widthIn(300.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(text = "Done", fontSize = 14.sp, color = Color.White, fontFamily = fontFamily)
                }







            }



        }

    }
}