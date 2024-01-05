package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.StealSequenceScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7

@Composable
fun ResultScreen(modifier:Modifier=Modifier) {
    Box(
        modifier = modifier.background(
            Brush.linearGradient(
                colors = listOf(virtual_plant_background3, virtual_plant_background),
                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        ).fillMaxSize()
    ){  ElevatedCard(
        modifier = Modifier.padding(16.dp)
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
            .heightIn(400.dp)
            .clip(
                RoundedCornerShape(24.dp)
            )
            .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Image(
                painter = painterResource(id = R.drawable.p35),
                contentDescription = "petplantname",
                modifier = Modifier.size(150.dp).clip(CircleShape)
            )
            Spacer(modifier =Modifier.size(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Row(
                    modifier = Modifier
                        .weight(4f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "Level 2",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier =Modifier.size(4.dp))
                Row(
                    modifier = Modifier
                        .weight(4f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "Water Type",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start
                    )
                }
            }
            Spacer(modifier =Modifier.size(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Row(
                    modifier = Modifier
                        .weight(4f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "Poisonous",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier =Modifier.size(4.dp))
                Row(
                    modifier = Modifier
                        .weight(4f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "Angry",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start
                    )
                }
            }
            Spacer(modifier =Modifier.size(16.dp))
            Button(
                onClick = {
//                            onSteal()
                },
                modifier = Modifier
                    .heightIn(65.dp)
                    .widthIn(120.dp).offset(y=40.dp)

                ,
                colors = ButtonDefaults.buttonColors(
                    virtual_plant_background7
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Done",
                    modifier = Modifier
                        .widthIn(50.dp),
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
            }
        }

    }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewResultScreen() {
    ResultScreen()
}