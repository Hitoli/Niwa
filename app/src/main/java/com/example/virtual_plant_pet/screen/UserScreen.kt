package com.example.virtual_plant_pet.screen

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.window.DialogProperties
import com.example.solus.authScreens.authUtils.MyCircle
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virual_plant_background1
import com.example.virtual_plant_pet.ui.theme.virual_plant_background2

//@Preview(showBackground = true)
@Composable
fun UserScreen(pad: PaddingValues) {

//    UserScreenOnBoardingAlert()

    var plantList = listOf(
        R.drawable.p3,
        R.drawable.p2,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,
        R.drawable.p7,
        R.drawable.p1,
        R.drawable.p8,
        R.drawable.p9,
        R.drawable.p10,
        R.drawable.p11,
        R.drawable.p12,
        R.drawable.p13,
        R.drawable.p14,
        R.drawable.p15,
        R.drawable.p16,
        R.drawable.p17,
        R.drawable.p18,
        R.drawable.p19,
        R.drawable.p20,
    )
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
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .size(30.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.plant),
                contentDescription = "plant",
                modifier = Modifier
                    .size(120.dp)
                    .border(BorderStroke(3.dp, Color.Black), shape = RoundedCornerShape(100.dp))
                    .padding(12.dp)
            )

            Text(
                text = "Hitesh",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier
                    .size(30.dp)
            )

            Row {
                Divider(
                    thickness = 1.dp,
                    color = Color.Black,
                    modifier = Modifier.widthIn(max = 130.dp)
                )
                MyCircle(size = 10, color = Color.Black)
                Divider(
                    thickness = 1.dp,
                    color = Color.Black,
                    modifier = Modifier.widthIn(max = 130.dp)
                )
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
                Spacer(
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(
                    text = "Your Garden",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier
                        .size(30.dp)
                )
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 100.dp),
                    userScrollEnabled = true,
                    modifier = Modifier.padding(bottom = pad.calculateBottomPadding())
                ) {
                    items(plantList) { plants ->
                        UserScreenPlantCard(plants)
                    }
                }
            }
        }


    }
}


@Composable
fun UserScreenPlantCard(Image: Int) {
    Box(
        modifier = Modifier.padding(16.dp)

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
                .widthIn(100.dp)
                .heightIn(100.dp)
                .clip(
                    RoundedCornerShape(24.dp)
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
        ) {
            Image(
                painter = painterResource(id = Image),
                contentDescription = "petplantname",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreenOnBoardingAlert() {

    var dismiss by remember {
        mutableStateOf(true)
    }

    if(dismiss) {

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
                    text = "Welcome To Your Garden",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Collect plants in your garden and take care of them",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Showcase your garden and compare with others",
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
fun UserScreenPreview() {
//    UserScreenOnBoardingAlert()
    UserScreen(
        PaddingValues(10.dp)
    )
}