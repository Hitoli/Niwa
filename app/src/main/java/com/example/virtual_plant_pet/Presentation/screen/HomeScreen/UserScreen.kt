package com.example.virtual_plant_pet.Presentation.screen.HomeScreen

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.R

import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background6
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background72
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background8
import kotlinx.coroutines.launch

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(pad: PaddingValues, onFight: () -> Unit, onSteal: () -> Unit) {
    val SheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            initialValue = SheetValue.Hidden,
            skipPartiallyExpanded = true,
            skipHiddenState = false
        )
    )
    val coroutineScope = rememberCoroutineScope()

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
    BottomSheetScaffold(
        sheetContent = {
            UserScreenSheetContent(pad)
        },
        scaffoldState = SheetState,
        sheetSwipeEnabled = true,
        containerColor = virtual_plant_background.copy(alpha = 0.3f),
        sheetContainerColor = virtual_plant_background.copy(alpha = 0.5f),
        sheetDragHandle = {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "DragHandle",
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 16.dp),
                tint = Color.Black
            )
        }) {
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 90.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                )



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ElevatedCard(
                        modifier = Modifier
                            .padding(16.dp)

//                        .shadow(
//                            elevation = 20.dp,
//                            spotColor = Color.Gray,
//                            shape = RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        )
                            .border(
                                border = BorderStroke(0.2.dp, Color.Gray),
                                shape = RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .fillMaxWidth(0.45f)
                            .fillMaxHeight(0.1f)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .weight(6f),
                        colors = CardDefaults.cardColors(virtual_plant_background7)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.shopicons),
                                contentDescription = "Profile",
                                modifier = Modifier
                                    .size(120.dp)
                                    .padding(5.dp)
                                    .weight(4f)
                            )

                            Text(
                                text = "Shop",
                                modifier = Modifier
                                    .widthIn(50.dp)
                                    .weight(4f)
                                    .clickable {
                                        coroutineScope.launch {
                                            SheetState.bottomSheetState.expand()
                                        }
                                    },
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Start
                            )


                        }

                    }
                    Spacer(
                        modifier = Modifier
                            .size(4.dp)
                    )

                    ElevatedCard(
                        modifier = Modifier
                            .padding(16.dp)
//                        .shadow(
//                            elevation = 20.dp,
//                            spotColor = Color.Gray,
//                            shape = RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        )
                            .border(
                                border = BorderStroke(0.2.dp, Color.Gray),
                                shape = RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .fillMaxWidth(0.45f)
                            .fillMaxHeight(0.1f)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 16.dp,
                                    topStart = 16.dp,
                                    bottomEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .weight(6f),
                        colors = CardDefaults.cardColors(virtual_plant_background7)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.questicons),
                                contentDescription = "Profile",
                                modifier = Modifier
                                    .size(120.dp)
                                    .padding(5.dp)
                                    .weight(4f)
                            )

                            Text(
                                text = "Quests",
                                modifier = Modifier
                                    .widthIn(50.dp)
                                    .weight(4f)
                                    .clickable {
                                        coroutineScope.launch {
                                            SheetState.bottomSheetState.expand()
                                        }
                                    },
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Start
                            )


                        }

                    }
                }




                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                )

                Row {
                    Divider(
                        thickness = 1.dp,
                        color = virtual_plant_background7,
                        modifier = Modifier.widthIn(max = 100.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .size(10.dp)
                            .shadow(
                                elevation = 5.dp,
                                spotColor = Color.Gray,
                                shape = CircleShape
                            )
                    )
                    MyCircle(
                        size = 10, color = virtual_plant_background8.copy(alpha = 0.6f),
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Divider(
                        thickness = 1.dp,
                        color = virtual_plant_background7,

                        modifier = Modifier.widthIn(max = 100.dp)
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
                        ),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.planthomescreen),
                                contentDescription = "playarea",
                                modifier = Modifier
                                    .size(300.dp)
                                    .clip(RoundedCornerShape(24.dp))

                            )
                            Spacer(modifier = Modifier.size(16.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(80.dp)
                                    .padding(
                                        bottom = pad.calculateBottomPadding(),
                                        start = 16.dp,
                                        end = 16.dp
                                    ),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(
                                    onClick = {
                                        onFight()
                                    },
                                    modifier = Modifier
                                        .heightIn(65.dp)
                                        .widthIn(120.dp)
                                        .weight(4f),
//                                    .shadow(
//                                        elevation = 10.dp,
//                                        spotColor = Color.Black,
//                                        shape = RoundedCornerShape(10.dp)
//                                    ),
                                    colors = ButtonDefaults.buttonColors(
                                        virtual_plant_background7
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .heightIn(45.dp)
                                            .widthIn(120.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {

                                        Image(
                                            painter = painterResource(id = R.drawable.fighticon),
                                            contentDescription = "Profile",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .padding(5.dp)
                                                .clip(CircleShape)

                                        )

                                        Text(
                                            text = "Fight",
                                            modifier = Modifier
                                                .widthIn(50.dp)
                                                .weight(4f),
                                            fontSize = 20.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.SansSerif,
                                            textAlign = TextAlign.Start
                                        )


                                    }
                                }
                                Spacer(
                                    modifier = Modifier
                                        .size(8.dp)
                                )
                                Button(
                                    onClick = {
                                        onSteal()
                                    },
                                    modifier = Modifier
                                        .heightIn(65.dp)
                                        .widthIn(120.dp)
                                        .weight(4f)
//                                    .shadow(
//                                        elevation = 4.dp,
//                                        spotColor = Color.Black,
//                                        shape = RoundedCornerShape(10.dp)
//                                    )
                                    ,
                                    colors = ButtonDefaults.buttonColors(
                                        virtual_plant_background7
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .heightIn(45.dp)
                                            .widthIn(120.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {

                                        Image(
                                            painter = painterResource(id = R.drawable.stealicon),
                                            contentDescription = "Profile",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .padding(5.dp)
                                                .clip(CircleShape)
                                        )

                                        Text(
                                            text = "Steal",
                                            modifier = Modifier
                                                .widthIn(50.dp)
                                                .weight(4f),
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
                }
            }


        }

    }

}

@Composable
fun UserScreenSheetGarden() {
    //                Spacer(
//                    modifier = Modifier
//                        .size(30.dp)
//                )
//                Text(
//                    text = "Your Garden",
//                    modifier = Modifier.fillMaxWidth(),
//                    fontSize = 25.sp,
//                    color = Color.Black,
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif,
//                    textAlign = TextAlign.Center
//                )
//                Spacer(
//                    modifier = Modifier
//                        .size(30.dp)
//                )
//                LazyVerticalGrid(
//                    columns = GridCells.Adaptive(minSize = 100.dp),
//                    userScrollEnabled = true,
//                    modifier = Modifier.padding(bottom = pad.calculateBottomPadding())
//                ) {
//                    items(plantList) { plants ->
//                        UserScreenPlantCard(plants)
//                    }
//                }
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

    if (dismiss) {

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

@Composable
fun UserScreenSheetContent(pad: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(
                Color.White,
                RoundedCornerShape(16.dp)
            )
            .padding(bottom = pad.calculateBottomPadding()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        items(5) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(10.dp).shadow(
                        elevation = 5.dp,
                        spotColor = Color.Black,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        BorderStroke(
                            1.dp,
                            Color.Black
                        ), RoundedCornerShape(16.dp)
                    ).clip(RoundedCornerShape(16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.stealicon),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(5.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Steal",
                    modifier = Modifier
                        .widthIn(50.dp)
                        .weight(4f),
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
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
        PaddingValues(10.dp), onFight = {}, onSteal = {}
    )
}