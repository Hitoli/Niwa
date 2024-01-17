package com.example.virtual_plant_pet.Presentation.screen.HomeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.zIndex
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7

@Composable
fun OnBoardingForFightScreen(
    modifier: Modifier = Modifier,
    onFight: () -> Unit,
    pad: PaddingValues,
    Screen: String
) {
    Box(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(virtual_plant_background3, virtual_plant_background),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .padding(top = pad.calculateTopPadding())
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {

                OnBoardingForFightScreenPlantCard(Image = R.drawable.p35)
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
                        .fillMaxWidth()
                        .height(120.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(
                        text = "You have Challenged Sam",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )




                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(virtual_plant_background,virtual_plant_background3),

                            )
                        )
                        .fillMaxHeight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Spacer(modifier = Modifier.size(16.dp))
                    Button(
                        onClick = {
                            onFight()
                        },
                        modifier = Modifier
                            .padding(10.dp)
                            .heightIn(65.dp)
                            .widthIn(120.dp).offset(y=-80.dp).border(BorderStroke(width = 0.5.dp,Color.Black),
                                RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            virtual_plant_background7
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Battle",
                            modifier = Modifier
                                .widthIn(50.dp),
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Light,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Start
                        )
                    }
                    OnBoardingForFightScreenPlantCard2(R.drawable.farmers)

                    Text(
                        text = "Level 1",
                        modifier = Modifier
                            .widthIn(50.dp),
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )

                }


            }
        }
    }
}

@Composable
fun OnBoardingForFightScreenPlantCard(Image: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(CircleShape)
    ) {


        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.farmers),
                contentDescription = "petplantname",
                modifier = Modifier
                    .size(100.dp)

            )
            Text(
                text = "Level 2",
                modifier = Modifier
                    .widthIn(50.dp),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            )
        }


    }
}

@Composable
fun OnBoardingForFightScreenPlantCard2(Image:Int) {
    Box(
        modifier = Modifier
            .widthIn(100.dp)
            .heightIn(100.dp)
    ) {

        ElevatedCard(
            modifier = Modifier
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color.Gray,
                    shape = CircleShape
                )
                .border(
                    border = BorderStroke(0.2.dp, Color.Gray),
                    shape = CircleShape
                )
                .widthIn(100.dp)
                .heightIn(100.dp)
                .clip(
                    CircleShape
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
        ) {
            Image(
                painter = painterResource(id = Image),
                contentDescription = "petplantname",
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnBoardingForFightScreen() {
    OnBoardingForFightScreen(onFight = {}, pad = PaddingValues(20.dp), Screen = "Fight")
}