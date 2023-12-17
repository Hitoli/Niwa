package com.example.virtual_plant_pet.navigation

import android.util.Size
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.material.icons.rounded.Adjust
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.navigation.navUtils.bottomNavigationdata
import com.example.virtual_plant_pet.screen.FightScreen
import com.example.virtual_plant_pet.screen.PlantsInTheWildScreen
import com.example.virtual_plant_pet.screen.UserScreen
import com.example.virtual_plant_pet.screen.VirtualPlantScreen
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background4
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background5
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.temporal.TemporalAmount

@Preview(showBackground = true)
@Composable
fun appNavMapreview() {
    appNavMap()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun appNavMap(navController: NavHostController = rememberNavController()) {

    var isGameScreen by remember {
        mutableStateOf(false)
    }


    Scaffold(topBar = {
        if (!isGameScreen) {
            TopAppBar(
                title = { /*TODO*/ },
                navigationIcon = {


                    VirtualPlantScreenFeedIndicatorCircleCard(
                        modifier = Modifier
                            .widthIn(40.dp)
                            .heightIn(40.dp)
                            .clip(
                                CircleShape
                            )
                    )

                }, actions = {
                    VirtualPlantScreenFeedUserCircleCard(
                        modifier = Modifier
                            .widthIn(40.dp)
                            .heightIn(40.dp)
                            .clip(
                                CircleShape
                            )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                modifier = Modifier.padding(10.dp)
            )
        }
    },

        bottomBar = {
            if (!isGameScreen) {


                BottomAppBar(
                    containerColor = Color.White,
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp
                            )
                        )
                        .heightIn(max = 70.dp)
                        .border(
                            BorderStroke(.2.dp, Color.DarkGray), shape = RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp
                            )
                        )
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Gray,
                            shape = RoundedCornerShape(
                                topStart = 25.dp,
                                topEnd = 25.dp
                            )
                        )
                ) {
                    bottomNavMap(navController)
                }
            }
        }
    ) {


        val pad = it

        NavHost(
            navController = navController,
            startDestination = navScreens.bottomScreens.route
        ) {
            navigation(
                startDestination = navScreens.ProfileScreen.route,
                route = navScreens.bottomScreens.route
            ) {
                composable(navScreens.HomeScreen.route) {
                    isGameScreen = false
                    PlantsInTheWildScreen(pad)
                }
                composable(navScreens.FeedScreen.route) {
                    isGameScreen = false
                    VirtualPlantScreen(modifier = Modifier, pad)
                }
                composable(navScreens.ProfileScreen.route) {
                   BackHandler(enabled = true) {
                       isGameScreen = false
                   }
                    UserScreen(pad, onFight = {
                        navController.navigate(navScreens.gameScreens.route){
                            popUpTo(navScreens.appNavScreen.route){
                                inclusive=true
                            }
                        }
                        isGameScreen = true
                    }, onSteal = {
                        isGameScreen = true
                    })
                }
                gameNavMap(navController, pad)

            }
        }
    }
}

@Composable
fun VirtualPlantScreenResourcesIndicator(modifier: Modifier, water: Int, soil: Int, solar: Int) {
    Row(
        modifier = modifier
            .padding(top = 8.dp, end = 10.dp, start = 10.dp, bottom = 1.dp)
            .clip(RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier
                .widthIn(10.dp)
                .heightIn(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.water),
                modifier = Modifier.size(35.dp),
                contentDescription = "water",
                colorFilter = ColorFilter.tint(
                    virtual_plant_background3
                )
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = water.toString(), color = Color.White, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier
                .widthIn(10.dp)
                .heightIn(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.soilnutrients),
                modifier = Modifier.size(35.dp),
                contentDescription = "water",
                colorFilter = ColorFilter.tint(
                    virtual_plant_background4
                )
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = soil.toString(), color = Color.White, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier
                .widthIn(10.dp)
                .heightIn(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunshine),
                modifier = Modifier.size(35.dp),
                contentDescription = "water",
                colorFilter = ColorFilter.tint(
                    virtual_plant_background5
                )
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = solar.toString(), color = Color.White, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.size(12.dp))
//

    }

}

@Composable
fun VirtualPlantScreenFeedIndicatorCircleCard(
    modifier: Modifier
) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    val corotine = rememberCoroutineScope()

    ElevatedCard(
        modifier = modifier, colors = CardDefaults.cardColors(Color.White)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.mineralniva),
            contentDescription = "Plant",
            modifier = Modifier
                .size(40.dp)
                .padding(6.dp)
                .clickable {
                    isVisible = true
                    corotine.launch {
                        delay(8000)
                        isVisible = false

                    }

                }, tint = Color.Black
        )

    }
    AppNavMapIndicatorAlertBox(isVisible = isVisible, onIsVisible = {
        isVisible = it
    }, 100, 120, 80, 120, 110, 120)


}

@Composable
fun VirtualPlantScreenFeedUserCircleCard(
    modifier: Modifier
) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    val corotine = rememberCoroutineScope()

    ElevatedCard(
        modifier = modifier, colors = CardDefaults.cardColors(Color.White)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.plant),
            contentDescription = "Plant",
            modifier = Modifier
                .size(40.dp)
                .padding(6.dp)
                .clickable {
                    isVisible = true
                    corotine.launch {
                        delay(8000)
                        isVisible = false

                    }

                }, tint = Color.Black
        )

    }
    AppNavMapIndicatorAlertBox(isVisible = isVisible, onIsVisible = {
        isVisible = it
    }, 100, 120, 80, 120, 110, 120)


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavMapIndicatorAlertBox(
    isVisible: Boolean,
    onIsVisible: (Boolean) -> Unit,
    usedWaterAmount: Int,
    totalWaterAmount: Int,
    usedSoilAmount: Int,
    totalSoilAmount: Int,
    usedSolarAmount: Int,
    totalSolarAmount: Int
) {

    val waterPercentage = animateFloatAsState(
        targetValue = usedWaterAmount.toFloat() / totalWaterAmount.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )
    val soilPercentage = animateFloatAsState(
        targetValue = usedSoilAmount.toFloat() / totalSoilAmount.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )
    val solarPercentage = animateFloatAsState(
        targetValue = usedSolarAmount.toFloat() / totalSolarAmount.toFloat(),
        label = "water",
        animationSpec = tween(durationMillis = 1000)
    )

    if (isVisible) {
        AlertDialog(
            onDismissRequest = { onIsVisible(false) },
            properties = DialogProperties(true, true),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .clip(
                    RoundedCornerShape(24.dp)
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VirtualPlantScreenResourcesIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(50.dp)
                        .padding(10.dp)
                        .background(Color.Transparent, RoundedCornerShape(16.dp)),
                    usedWaterAmount, usedSoilAmount, usedSolarAmount
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Canvas(modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)) {
                            val width = size.width
                            val height = size.height
                            val waterWavesYPosition = (1 - waterPercentage.value) * height
                            val waterPath = Path().apply {
                                moveTo(
                                    x = 0f,
                                    y = waterWavesYPosition
                                )
                                lineTo(
                                    x = width - 20f,
                                    y = waterWavesYPosition
                                )
                                lineTo(
                                    x = width - 20f,
                                    y = height
                                )
                                lineTo(
                                    x = 0f,
                                    y = height
                                )
                                close()
                            }

                            drawPath(waterPath, virtual_plant_background3)


                        }
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = "Water",
                            color = Color.White,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Canvas(modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)) {
                            val width = size.width
                            val height = size.height
                            val waterWavesYPosition = (1 - soilPercentage.value) * height
                            val waterPath = Path().apply {
                                moveTo(
                                    x = 0f,
                                    y = waterWavesYPosition
                                )
                                lineTo(
                                    x = width - 20f,
                                    y = waterWavesYPosition
                                )
                                lineTo(
                                    x = width - 20f,
                                    y = height
                                )
                                lineTo(
                                    x = 0f,
                                    y = height
                                )
                                close()
                            }

                            drawPath(waterPath, virtual_plant_background4)


                        }
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = "Soil",
                            color = Color.White,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(100.dp)
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Canvas(modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)) {
                            val width = size.width
                            val height = size.height
                            val waterWavesYPosition = (1 - solarPercentage.value) * height
                            val waterPath = Path().apply {
                                moveTo(
                                    x = 0f,
                                    y = waterWavesYPosition
                                )
                                lineTo(
                                    x = width - 20f,
                                    y = waterWavesYPosition
                                )
                                lineTo(
                                    x = width - 20f,
                                    y = height
                                )
                                lineTo(
                                    x = 0f,
                                    y = height
                                )
                                close()
                            }

                            drawPath(waterPath, virtual_plant_background5)


                        }
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = "Solar",
                            color = Color.White,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }

                }
            }


        }
    }

}


@Composable
fun bottomNavMap(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(containerColor = Color.White) {
        bottomNavigationdata().bottomNavigationItems()
            .forEachIndexed { index, bottomNavigationdata ->
                NavigationBarItem(
                    selected = currentRoute == bottomNavigationdata.route,
                    onClick = {
                        navController.navigate(bottomNavigationdata.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Row(
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Image(
                                painter = painterResource(id = bottomNavigationdata.icon),
                                contentDescription = bottomNavigationdata.label,
                                colorFilter = ColorFilter.tint(Color.Black)
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            AnimatedVisibility(
                                visible = currentRoute == bottomNavigationdata.route,
                                enter = expandHorizontally(
                                    animationSpec = tween(
                                        durationMillis = 600,
                                        easing = LinearOutSlowInEasing
                                    )
                                ),
                                exit = shrinkHorizontally(
                                    animationSpec = tween(
                                        durationMillis = 600,
                                        easing = LinearOutSlowInEasing
                                    )
                                )
                            ) {

                                Text(
                                    text = bottomNavigationdata.label,
                                    fontSize = 10.sp,
                                    color = Color.Black,
                                    fontFamily = fontFamily
                                )
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        Color.Black,
                        indicatorColor = Color.White
                    ),

                    )
            }
    }
}