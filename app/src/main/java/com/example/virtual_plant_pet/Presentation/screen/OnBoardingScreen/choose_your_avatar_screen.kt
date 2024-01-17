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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background8
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundBlackShade

@Composable

fun ChooseYourAvatarScreen(
    onNavigate: () -> Unit,
    getAvatar: (Int) -> Unit,
    empty: Boolean,
    isSelected: Boolean,
    isSelected1: Boolean,
    isSelected2: Boolean,
    isSelected3: Boolean,
    isSelected4: Boolean,
    isSelected5: Boolean,
    getIsSelected: (Boolean) -> Unit,
    getIsSelected1: (Boolean) -> Unit,
    getIsSelected2: (Boolean) -> Unit,
    getIsSelected3: (Boolean) -> Unit,
    getIsSelected4: (Boolean) -> Unit,
    getIsSelected5: (Boolean) -> Unit,

) {

    var borderColor = if (isSelected) virtual_plant_background7 else Color.Transparent
    var borderColor1 = if (isSelected1) virtual_plant_background7 else Color.Transparent
    var borderColor2 = if (isSelected2) virtual_plant_background7 else Color.Transparent
    var borderColor3 = if (isSelected3) virtual_plant_background7 else Color.Transparent
    var borderColor4 = if (isSelected4) virtual_plant_background7 else Color.Transparent
    var borderColor5 = if (isSelected5) virtual_plant_background7 else Color.Transparent



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
                .fillMaxHeight(.8f)
                .clip(
                    RoundedCornerShape(
                        16.dp
                    )
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(
                virtual_plant_backgroundBlackShade.copy(alpha = 0.5f)
            ), elevation = CardDefaults.cardElevation(0.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.size(5.dp))


                Text(
                    text = "Choose your Avatar",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(5.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.farmers),
                            contentDescription = "player",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .border(
                                    BorderStroke(8.dp, borderColor), shape = CircleShape
                                )
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    getIsSelected(true)
                                    getIsSelected1(false)
                                    getIsSelected2(false)
                                    getIsSelected3(false)
                                    getIsSelected4(false)
                                    getIsSelected5(false)
                                    getAvatar(R.drawable.farmers)
                                })
                        Image(
                            painter = painterResource(id = R.drawable.farmers2),
                            contentDescription = "player",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .border(
                                    BorderStroke(8.dp, borderColor1), shape = CircleShape
                                )
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    getIsSelected(false)
                                    getIsSelected1(true)
                                    getIsSelected2(false)
                                    getIsSelected3(false)
                                    getIsSelected4(false)
                                    getIsSelected5(false)
                                    getAvatar(R.drawable.farmers2)
                                }
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.farmers3),
                            contentDescription = "player",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .border(
                                    BorderStroke(8.dp, borderColor2), shape = CircleShape
                                )
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    getIsSelected(false)
                                    getIsSelected1(false)
                                    getIsSelected2(true)
                                    getIsSelected3(false)
                                    getIsSelected4(false)
                                    getIsSelected5(false)
                                    getAvatar(R.drawable.farmers3)
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.farmers4),
                            contentDescription = "player",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .border(
                                    BorderStroke(8.dp, borderColor3), shape = CircleShape
                                )
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    getIsSelected(false)
                                    getIsSelected1(false)
                                    getIsSelected2(false)
                                    getIsSelected3(true)
                                    getIsSelected4(false)
                                    getIsSelected5(false)
                                    getAvatar(R.drawable.farmers4)
                                }
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.farmers5),
                            contentDescription = "player",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .border(
                                    BorderStroke(8.dp, borderColor4), shape = CircleShape
                                )
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    getIsSelected(false)
                                    getIsSelected1(false)
                                    getIsSelected2(false)
                                    getIsSelected3(false)
                                    getIsSelected4(true)
                                    getIsSelected5(false)
                                    getAvatar(R.drawable.farmers5)
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.farmerss),
                            contentDescription = "player",
                            contentScale = ContentScale.FillBounds, modifier = Modifier
                                .border(
                                    BorderStroke(8.dp, borderColor5), shape = CircleShape
                                )
                                .width(100.dp)
                                .height(100.dp)
                                .clickable {
                                    getIsSelected(false)
                                    getIsSelected1(false)
                                    getIsSelected2(false)
                                    getIsSelected3(false)
                                    getIsSelected4(false)
                                    getIsSelected5(true)
                                    getAvatar(R.drawable.farmerss)
                                }
                        )
                    }

                }
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

                ) {
                    Text(
                        text = "Please Select your avatar...",
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
                    Text(
                        text = "Done",
                        fontSize = 14.sp,
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
fun PreviewChooseYourAvatarScreen() {
    ChooseYourAvatarScreen(onNavigate =
    {},
        getAvatar = {

        },
        empty = false,
        isSelected = false,
        isSelected1 = false,
        isSelected2 = false,
        isSelected3 = false,
        isSelected4 = false,
        isSelected5 = false,
        getIsSelected = {},
        getIsSelected1 = {},
        getIsSelected2 = {},
        getIsSelected3 = {},
        getIsSelected4 = {},
        getIsSelected5 = {},
       )
}