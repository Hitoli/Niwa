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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.HomeUtils.shopItems
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.R

import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background6
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background72
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background8
import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundBlackShade
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    pad: PaddingValues,
    onFight: () -> Unit,
    onSteal: () -> Unit,
    dismiss: Boolean,
    getDismiss: (Boolean) -> Unit,
    shopList: List<shopItems>,
    onQuestDismiss: Boolean,
    getQuestDismiss: (Boolean) -> Unit,
    getShopProduct: (Int) -> Unit
) {
    val SheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            initialValue = SheetValue.Hidden,
            skipPartiallyExpanded = true,
            skipHiddenState = false
        )
    )
    val coroutineScope = rememberCoroutineScope()

//    UserScreenOnBoardingAlert(dismiss = dismiss, getDismiss = {
//        getDismiss(it)
//    })


    BottomSheetScaffold(
        sheetContent = {
            UserScreenSheetContent(pad, shopList = shopList, getShopProduct = {
                getShopProduct(it)
            })
        },
        scaffoldState = SheetState,
        sheetSwipeEnabled = true,
        containerColor = virtual_plant_background7.copy(alpha = 0.3f),
        sheetContainerColor = virtual_plant_background7.copy(alpha = 0.5f),
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


//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .heightIn(40.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    ElevatedCard(
//                        modifier = Modifier
//                            .padding(16.dp)
//
//                            .shadow(
//                                elevation = 20.dp,
//                                spotColor = Color.Gray,
//                                shape = RoundedCornerShape(
//                                    topEnd = 16.dp,
//                                    topStart = 16.dp,
//                                    bottomEnd = 16.dp,
//                                    bottomStart = 16.dp
//                                )
//                            )
//                            .border(
//                                border = BorderStroke(0.2.dp, Color.Gray),
//                                shape = RoundedCornerShape(
//                                    topEnd = 16.dp,
//                                    topStart = 16.dp,
//                                    bottomEnd = 16.dp,
//                                    bottomStart = 16.dp
//                                )
//                            )
//                            .fillMaxWidth(0.45f)
//                            .height(65.dp)
//                            .clip(
//                                RoundedCornerShape(
//                                    topEnd = 16.dp,
//                                    topStart = 16.dp,
//                                    bottomEnd = 16.dp,
//                                    bottomStart = 16.dp
//                                )
//                            )
//                            .weight(6f),
//                        colors = CardDefaults.cardColors(virtual_plant_background7.copy(alpha = 0.8f)),elevation = CardDefaults.cardElevation(0.dp)
//                    ) {
//                        Row(
//                            modifier = Modifier.fillMaxSize(),
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.SpaceEvenly
//                        ) {
//
//                            Image(
//                                painter = painterResource(id = R.drawable.shopicons),
//                                contentDescription = "Profile",
//                                modifier = Modifier
//                                    .size(120.dp)
//                                    .padding(5.dp)
//                                    .weight(4f)
//                            )
//
//                            Text(
//                                text = "Shop",
//                                modifier = Modifier
//                                    .widthIn(50.dp)
//                                    .weight(4f)
//                                    .clickable {
//                                        coroutineScope.launch {
//                                            SheetState.bottomSheetState.expand()
//                                        }
//                                    },
//                                fontSize = 20.sp,
//                                color = Color.White,
//                                fontWeight = FontWeight.Light,
//                                fontFamily = FontFamily.SansSerif,
//                                textAlign = TextAlign.Start
//                            )
//
//
//                        }
//
//                    }
//                    Spacer(
//                        modifier = Modifier
//                            .size(4.dp)
//                    )
//
//                    ElevatedCard(
//                        modifier = Modifier
//                            .padding(16.dp)
//
//                            .shadow(
//                                elevation = 20.dp,
//                                spotColor = Color.Gray,
//                                shape = RoundedCornerShape(
//                                    topEnd = 16.dp,
//                                    topStart = 16.dp,
//                                    bottomEnd = 16.dp,
//                                    bottomStart = 16.dp
//                                )
//                            )
//                            .border(
//                                border = BorderStroke(0.2.dp, Color.Gray),
//                                shape = RoundedCornerShape(
//                                    topEnd = 16.dp,
//                                    topStart = 16.dp,
//                                    bottomEnd = 16.dp,
//                                    bottomStart = 16.dp
//                                )
//                            )
//                            .fillMaxWidth(0.45f)
//                            .height(65.dp)
//                            .clip(
//                                RoundedCornerShape(
//                                    topEnd = 16.dp,
//                                    topStart = 16.dp,
//                                    bottomEnd = 16.dp,
//                                    bottomStart = 16.dp
//                                )
//                            )
//                            .weight(6f),
//                        colors = CardDefaults.cardColors(virtual_plant_background7.copy(alpha = 0.8f)),elevation = CardDefaults.cardElevation(0.dp)
//                    ) {
//                        Row(
//                            modifier = Modifier.fillMaxSize(),
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.SpaceEvenly
//                        ) {
//
//                            Image(
//                                painter = painterResource(id = R.drawable.questicons),
//                                contentDescription = "Profile",
//                                modifier = Modifier
//                                    .size(120.dp)
//                                    .padding(5.dp)
//                                    .weight(4f)
//                            )
//
//                            Text(
//                                text = "Quests",
//                                modifier = Modifier
//                                    .widthIn(50.dp)
//                                    .weight(4f)
//                                    .clickable {
//                                        getQuestDismiss(true)
//                                    },
//                                fontSize = 20.sp,
//                                color = Color.White,
//                                fontWeight = FontWeight.Light,
//                                fontFamily = FontFamily.SansSerif,
//                                textAlign = TextAlign.Start
//                            )
//
//
//                        }
//
//                    }
//                }


                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                )

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
                            modifier = Modifier.fillMaxWidth()
                                .height(150.dp)
                                .align(Alignment.TopCenter)
                                .background( Brush.verticalGradient(
                                    colors = listOf(virtual_plant_background7, Color.White),
                                )),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Welcome, Hitesh",
                                modifier = Modifier
                                    .fillMaxWidth().padding(8.dp),
                                fontSize = 24.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center
                            )
//                            Row(
//                                verticalAlignment = Alignment.CenterVertically,
//                                horizontalArrangement = Arrangement.Center,
//                                modifier = Modifier.padding(8.dp)
//                            ) {
//                                Text(
//                                    text = "Level: 9",
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .weight(4f),
//                                    fontSize = 20.sp,
//                                    color = Color.White,
//                                    fontWeight = FontWeight.Bold,
//                                    fontFamily = FontFamily.SansSerif,
//                                    textAlign = TextAlign.Center
//                                )
//                                Spacer(modifier = Modifier.size(10.dp))
//                                Text(
//                                    text = "Plants: 3",
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .weight(4f),
//                                    fontSize = 20.sp,
//                                    color = Color.White,
//                                    fontWeight = FontWeight.Bold,
//                                    fontFamily = FontFamily.SansSerif,
//                                    textAlign = TextAlign.Center
//                                )
//                            }
                            Spacer(modifier = Modifier.size(8.dp))
                            Row {
                                Divider(
                                    thickness = 1.dp,
                                    color = Color.White,
                                    modifier = Modifier.widthIn(max = 130.dp)
                                )
                                MyCircle(size = 10, color = Color.White)
                                Divider(
                                    thickness = 1.dp,
                                    color = Color.White,
                                    modifier = Modifier.widthIn(max = 130.dp)
                                )
                            }
                        }


                        Spacer(modifier = Modifier.size(8.dp))
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
                                    onClick = { onFight() },
                                    modifier = Modifier
                                        .heightIn(65.dp)
                                        .widthIn(120.dp)
                                        .weight(4f)
                                        .border(
                                            BorderStroke(
                                                0.5.dp,
                                                virtual_plant_backgroundBlackShade
                                            ), shape = RoundedCornerShape(16.dp)
                                        ),
                                    colors = ButtonDefaults.buttonColors(virtual_plant_background7),
                                    shape = RoundedCornerShape(16.dp)
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
                                        Spacer(modifier = Modifier.size(2.dp))


                                        Text(
                                            text = "Battle",
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
                                    onClick = { onSteal() },
                                    modifier = Modifier
                                        .heightIn(65.dp)
                                        .widthIn(120.dp)
                                        .weight(4f)
                                        .border(
                                            BorderStroke(
                                                0.5.dp,
                                                virtual_plant_backgroundBlackShade
                                            ), shape = RoundedCornerShape(16.dp)
                                        ),
                                    colors = ButtonDefaults.buttonColors(virtual_plant_background7),
                                    shape = RoundedCornerShape(16.dp)
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
                                        Spacer(modifier = Modifier.size(2.dp))

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
//    QuestsUserScreen(onQuestDismiss = onQuestDismiss, getQuestDismiss = {
//        getQuestDismiss(it)
//    })


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreenOnBoardingAlert(dismiss: Boolean, getDismiss: (Boolean) -> Unit) {


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
                    .background(virtual_plant_backgroundBlackShade.copy(alpha = 0.5f))
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Welcome To Your Garden",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Collect plants in your garden and take care of them",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Showcase your garden and compare with others",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.size(8.dp))
                Button(
                    onClick = { getDismiss(false) },
                    modifier = Modifier
                        .heightIn(60.dp)
                        .widthIn(300.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(
                        text = "Ok, Got it",
                        fontSize = 14.sp,
                        color = Color.White,
                        fontFamily = fontFamily
                    )
                }
            }

        }
    }
}

@Composable
fun UserScreenSheetContent(
    pad: PaddingValues,
    shopList: List<shopItems>,
    getShopProduct: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                Color.Transparent,
                RoundedCornerShape(16.dp)
            )
            .padding(bottom = pad.calculateBottomPadding()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(shopList) { ListofItems ->
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(16.dp)
                    )
            ) {
                Image(
                    painter = painterResource(id = ListofItems.Image),
                    contentDescription = "petplantname",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopCenter),

                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.size(20.dp))

                Text(
                    text = ListofItems.shopItem,
                    modifier = Modifier
                        .padding(16.dp)
                        .widthIn(50.dp)
                        .align(Alignment.BottomCenter),
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Start
                )
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestsUserScreen(onQuestDismiss: Boolean, getQuestDismiss: (Boolean) -> Unit) {
    if (onQuestDismiss) {

        AlertDialog(
            onDismissRequest = { onQuestDismiss },
            properties = DialogProperties(true, true),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .padding(24.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    virtual_plant_backgroundBlackShade.copy(alpha = 0.8f)
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.size(40.dp))

                Text(
                    text = "Today's Quest",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(24.dp))


                Text(
                    text = "Fight a plant today",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(24.dp))

                Button(
                    onClick = { getQuestDismiss(false) },
                    modifier = Modifier
                        .heightIn(60.dp)
                        .widthIn(300.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(
                        text = "Ok, Got it",
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
fun UserScreenPreview() {
    val shipList = listOf<shopItems>(

        shopItems(Image = R.drawable.thornyarmor, shopItem = "Thorny Armor"),
        shopItems(Image = R.drawable.bubbleburst, shopItem = "Bubble Burst"),
        shopItems(Image = R.drawable.petalstorm, shopItem = "Petal Storm"),

        )
//    UserScreenOnBoardingAlert(dismiss = true, getDismiss = {})
    UserScreen(
        PaddingValues(10.dp), onFight = {}, onSteal = {}, getDismiss = {}, dismiss =
        true, getShopProduct = {}, shopList = shipList, getQuestDismiss = {}, onQuestDismiss = false
    )
}