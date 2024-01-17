//package com.example.virtual_plant_pet.Presentation.screen.HomeScreen.FightSequenceScreens
//
//import android.util.Log
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.heightIn
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Divider
//import androidx.compose.material3.ElevatedCard
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Path
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.virtual_plant_pet.R
//import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundLifeLine
//import com.example.virtual_plant_pet.ui.theme.virtual_plant_backgroundWater
//import kotlin.math.roundToInt
//
//@Composable
//fun Com() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceEvenly,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(10.dp)
//                    .weight(4f),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                ElevatedCard(
//                    modifier = Modifier
//                        .shadow(
//                            elevation = 10.dp,
//                            spotColor = Color.Gray,
//                            shape = RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        )
//                        .border(
//                            border = BorderStroke(0.2.dp, Color.Gray),
//                            shape = RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        )
//                        .width(200.dp)
//                        .height(100.dp)
//                        .clip(
//                            RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        ), colors = CardDefaults.cardColors(Color.White)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .width(200.dp)
//                            .heightIn(max = 50.dp)
//                            .padding(10.dp)
//                            .clip(RoundedCornerShape(8.dp))
//                            .shadow(
//                                elevation = 10.dp,
//                                spotColor = Color.Black,
//                                shape = RoundedCornerShape(8.dp)
//                            ),
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Canvas(
//                            modifier = Modifier
//                                .width(200.dp)
//                                .height(100.dp)
//                                .clip(RoundedCornerShape(8.dp))
//                                .border(
//                                    BorderStroke(0.2.dp, Color.Black),
//                                    shape = RoundedCornerShape(8.dp)
//                                )
//                        ) {
//                            val width = size.width
//                            val height = size.height
//                            val waterWavesYPosition = (1 - healthPercentagePlant1.value) * width
//                            val waterPath = Path().apply {
//                                moveTo(
//                                    x = 0f,
//                                    y = 0f
//                                )
//                                lineTo(
//                                    x = waterWavesYPosition,
//                                    y = 0f
//                                )
//                                lineTo(
//                                    x = waterWavesYPosition,
//                                    y = height
//                                )
//                                lineTo(
//                                    x = 0f,
//                                    y = height
//                                )
//                                close()
//                            }
//
//                            drawPath(waterPath, virtual_plant_backgroundLifeLine)
//
//
//                        }
//                        Spacer(modifier = Modifier.size(6.dp))
//
//                    }
//                    Text(
//                        text = "Mystique",
//                        color = Color.Black,
//                        modifier = Modifier
//                            .padding(top = 6.dp)
//                            .fillMaxWidth(),
//                        textAlign = TextAlign.Center,
//                        style = TextStyle(fontSize = 20.sp)
//                    )
//                }
//                Spacer(modifier = Modifier.size(10.dp))
//                Image(
//                    painter = painterResource(id = R.drawable.farmers),
//                    contentDescription = "player",
//                    contentScale = ContentScale.FillBounds, modifier = Modifier
//                        .width(100.dp)
//                        .height(100.dp)
//                )
//
//
//            }
//
//
//
//            Column(
//                modifier = Modifier
//                    .padding(10.dp)
//                    .weight(4f),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                ElevatedCard(
//                    modifier = Modifier
//                        .shadow(
//                            elevation = 10.dp,
//                            spotColor = Color.Gray,
//                            shape = RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        )
//                        .border(
//                            border = BorderStroke(0.2.dp, Color.Gray),
//                            shape = RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        )
//                        .width(200.dp)
//                        .height(100.dp)
//                        .clip(
//                            RoundedCornerShape(
//                                topEnd = 16.dp,
//                                topStart = 16.dp,
//                                bottomEnd = 16.dp,
//                                bottomStart = 16.dp
//                            )
//                        ), colors = CardDefaults.cardColors(Color.White)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .width(200.dp)
//                            .heightIn(max = 50.dp)
//                            .padding(10.dp)
//                            .clip(RoundedCornerShape(8.dp))
//                            .shadow(
//                                elevation = 10.dp,
//                                spotColor = Color.Black,
//                                shape = RoundedCornerShape(8.dp)
//                            ),
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Canvas(
//                            modifier = Modifier
//                                .width(200.dp)
//                                .height(100.dp)
//                                .clip(RoundedCornerShape(8.dp))
//                                .border(
//                                    BorderStroke(0.2.dp, Color.Black),
//                                    shape = RoundedCornerShape(8.dp)
//                                )
//                        ) {
//                            val width = size.width
//                            val height = size.height
//                            val waterWavesYPosition = (1 - healthPercentagePlant2.value) * width
//                            val waterPath = Path().apply {
//                                moveTo(
//                                    x = 0f,
//                                    y = 0f
//                                )
//                                lineTo(
//                                    x = waterWavesYPosition,
//                                    y = 0f
//                                )
//                                lineTo(
//                                    x = waterWavesYPosition,
//                                    y = height
//                                )
//                                lineTo(
//                                    x = 0f,
//                                    y = height
//                                )
//                                close()
//                            }
//
//                            drawPath(waterPath, virtual_plant_backgroundLifeLine)
//
//
//                        }
//                        Spacer(modifier = Modifier.size(6.dp))
//
//                    }
//                    Text(
//                        text = "Sam",
//                        color = Color.Black,
//                        modifier = Modifier
//                            .padding(top = 6.dp)
//                            .fillMaxWidth(),
//                        textAlign = TextAlign.Center,
//                        style = TextStyle(fontSize = 20.sp)
//                    )
//                }
//                Spacer(modifier = Modifier.size(10.dp))
//
//                Image(
//                    painter = painterResource(id = R.drawable.farmers),
//                    contentDescription = "player",
//                    contentScale = ContentScale.FillBounds, modifier = Modifier
//                        .width(100.dp)
//                        .height(100.dp)
//                )
//
//
//            }
//        }
//
////            Row(
////                modifier = Modifier.fillMaxWidth(),
////                verticalAlignment = Alignment.CenterVertically,
////                horizontalArrangement = Arrangement.SpaceEvenly
////            ) {
//
////                Box(
////                    modifier = Modifier
////                        .padding(1.dp)
////                        .width(138.dp)
////                        .height(204.dp)
////                        .background(color = Color(0x4D000000), shape = RoundedCornerShape(10.dp))
////                )
////            }
//        Spacer(modifier = Modifier.size(40.dp))
//        Box(
//            modifier = Modifier.width(300.dp)
//        ) {
//            Box(
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .width(202.dp)
//                    .height(75.dp)
//                    .background(
//                        color = Color(0x4D000000),
//                        shape = RoundedCornerShape(size = 10.dp)
//                    )
//            )
//            Row(
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .width(300.dp)
//                    .offset(x = 30.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.niwaplayingcard),
//                    contentDescription = "image description",
//                    contentScale = ContentScale.FillBounds, modifier = androidx.compose.ui.Modifier
//                        .width(sizeWidth1)
//                        .height(sizeHeight1)
////                            .offset(y = -60.dp)
//                        .offset { IntOffset(offsetXdrag.value, offsetYdrag.value) } .pointerInput(Unit) {
//                            detectDragGestures(onDrag = { change, dragAmount ->
//                                sizeWidth1 = 127.dp
//                                sizeHeight1 = 187.dp
//                                dragging = change.pressed
//                                Log.e("dragginf", change.pressed.toString())
//                                offsetx += dragAmount.x.roundToInt()
//                                offsety += dragAmount.y.roundToInt()
//                            }, onDragEnd = {
//                                offsetx = InitialPositionx
//                                offsety = InitialPositiony
//
//                            })
//                        }
//                )
//                Image(
//                    painter = painterResource(id = R.drawable.niwaplayingcard),
//                    contentDescription = "image description",
//                    contentScale = ContentScale.FillBounds, modifier = Modifier
//                        .width(87.dp)
//                        .height(127.dp)
//                        .offset(y = -75.dp, x = -30.dp)
//                )
////                    Image(
////                        painter = painterResource(id = R.drawable.niwaplayingcard),
////                        contentDescription = "image description",
////                        contentScale = ContentScale.FillBounds, modifier = Modifier
////                            .width( sizeWidth2 )
////                            .height(sizeHeight2)
////                            .offset(y = -60.dp, x = -60.dp)
////                            .graphicsLayer {
////                                rotationZ = rotation1
////                            }.offset { IntOffset(offsetXdrag2.value, offsetYdrag2.value) } .pointerInput(Unit) {
////                                detectDragGestures(onDrag = { change, dragAmount ->
////                                    sizeWidth2 = 127.dp
////                                    sizeHeight2 = 187.dp
////                                    rotation1 =0f;
////                                    change.consume()
////                                    dragging2 = change.pressed
////                                    Log.e("dragginf", change.pressed.toString())
////                                    offsetX2 += dragAmount.x
////                                    offsetY2 += dragAmount.y
////                                }, onDragEnd = {
////                                    offsetX2 = 0f
////                                    offsetY2 = 0f
////
////                                })
////                            }
////                    )
//            }
//
//
//        }
//        Row(
//            modifier = Modifier.padding(8.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Box(
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .background(Color(0x4D000000))
//                    .padding(16.dp)
//            ) {
//                Icon(
//                    painter = painterResource(R.drawable.water),
//                    contentDescription = "water",
//                    modifier = Modifier.size(30.dp),
//                    tint = Color.White
//                )
//            }
//
//            Spacer(modifier = Modifier.size(10.dp))
//            Box(modifier = Modifier) {
//
//
//                Row(
//                    modifier = Modifier
//                        .width(400.dp)
//                        .heightIn(max = 80.dp)
//                        .padding(10.dp)
//                        .clip(RoundedCornerShape(8.dp))
//                        .shadow(
//                            elevation = 10.dp,
//                            spotColor = Color.Black,
//                            shape = RoundedCornerShape(8.dp)
//                        ),
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Canvas(
//                        modifier = Modifier
//                            .width(400.dp)
//                            .height(80.dp)
//                            .clip(RoundedCornerShape(8.dp))
//                    ) {
//                        val width = size.width
//                        val height = size.height
//                        val waterWavesYPosition = (resourcePercentagePlant.value) * width
//                        val waterPath = Path().apply {
//                            moveTo(
//                                x = 0f,
//                                y = 0f
//                            )
//                            lineTo(
//                                x = waterWavesYPosition,
//                                y = 0f
//                            )
//                            lineTo(
//                                x = waterWavesYPosition,
//                                y = height
//                            )
//                            lineTo(
//                                x = 0f,
//                                y = height
//                            )
//                            close()
//                        }
//
//                        drawPath(waterPath, virtual_plant_backgroundWater)
//
//
//                    }
//                    Spacer(modifier = Modifier.size(6.dp))
//
//                }
//                Row(
//                    modifier = Modifier
//                        .align(Alignment.Center)
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Divider(
//                        modifier = Modifier
//                            .height(60.dp)
//                            .width(1.dp), color = Color.Black
//                    )
//                    Divider(
//                        modifier = Modifier
//                            .height(60.dp)
//                            .width(1.dp), color = Color.Black
//                    )
//                    Divider(
//                        modifier = Modifier
//                            .height(60.dp)
//                            .width(1.dp), color = Color.Black
//                    )
//                    Divider(
//                        modifier = Modifier
//                            .height(60.dp)
//                            .width(1.dp), color = Color.Black
//                    )
//                    Divider(
//                        modifier = Modifier
//                            .height(60.dp)
//                            .width(1.dp), color = Color.Black
//                    )
//
//                }
//
//            }
//        }
////
////            FightScreenSeqGameResult(true, onVisible = {
////
////            }, onDone = {})
//
//
//    }
//}