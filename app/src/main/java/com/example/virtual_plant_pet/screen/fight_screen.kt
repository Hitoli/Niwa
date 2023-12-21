package com.example.virtual_plant_pet.screen

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.fontFamily
import kotlinx.coroutines.launch

@Composable
fun FightScreen(pad:PaddingValues,onGameResult: ()->Unit) {
    var isOnVisible by remember{
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Image(
            painter = painterResource(id = R.drawable.niwaback3),
            contentDescription = "landscape",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(bottom = pad.calculateBottomPadding()), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.padding(start = 10.dp)){
                ElevatedCard(
                    modifier = Modifier
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Gray,
                            shape = RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        )
                        .border(
                            border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        )
                        .widthIn(150.dp)
                        .height(150.dp)
                        .clip(
                            RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.White)
                ){
                    Text(
                        text = "Poison Seed",
                        modifier = Modifier
                            .widthIn(150.dp)
                            .padding(top = 55.dp),
                        fontSize = 18.sp, color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default, textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.size(60.dp))
                Image(
                    painter = painterResource(id = R.drawable.p33),
                    contentDescription = "playarea",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(24.dp))

                )
            }
            Spacer(modifier = Modifier.size(25.dp))
            Row(Modifier.padding( end = 10.dp)){
                Image(
                    painter = painterResource(id = R.drawable.p35),
                    contentDescription = "playarea",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(24.dp))

                )
                Spacer(modifier = Modifier.size(60.dp))
                ElevatedCard(
                    modifier = Modifier
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Gray,
                            shape = RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        )
                        .border(
                            border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        )
                        .widthIn(150.dp)
                        .height(150.dp)
                        .clip(
                            RoundedCornerShape(
                                topEnd = 16.dp,
                                topStart = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 16.dp
                            )
                        ), colors = CardDefaults.cardColors(Color.White)
                ){
                    Text(
                        text = "Water Thrust",
                        modifier = Modifier
                            .widthIn(150.dp)
                            .padding(10.dp),
                        fontSize = 18.sp, color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default, textAlign = TextAlign.Center
                    )
                    Button(
                        onClick = {
                            isOnVisible =true
                        },
                        modifier = Modifier
                            .heightIn(65.dp)
                            .widthIn(150.dp)
                            .padding(10.dp)
                            .shadow(
                                elevation = 4.dp,
                                spotColor = Color.Black,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Use",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily = fontFamily
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.size(35.dp))
        }

    }
    FightScreenGameResult(isOnVisible, onVisible = {
        isOnVisible = it
    }, onDone = {
        onGameResult()
    })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FightScreenGameResult(onIsVisible:Boolean,onVisible: (Boolean)->Unit,onDone:()->Unit) {
    if(onIsVisible) {
        AlertDialog(
            onDismissRequest = { onVisible(false) },
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
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "You Win",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.p33),
                    contentDescription = "playarea",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(24.dp))

                )
                Row {
                    Text(
                        text = "XP",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "+2000",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                }

                Row {
                    Text(
                        text = "Plant Level",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "+1",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { onVisible(false)
                        onDone()},
                    modifier = Modifier
                        .heightIn(65.dp)
                        .widthIn(150.dp)
                        .padding(10.dp)
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Done",
                        fontSize = 20.sp,
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
fun FightScreenPreview() {
    FightScreen(PaddingValues(10.dp), onGameResult = {})
}