package com.example.virtual_plant_pet.navigation.NavMaps

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.solus.navigation.navUtils.navScreens
import com.example.virtual_plant_pet.Presentation.screen.FeedScreen.VirtualPlantScreen
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.HomeUtils.shopItems
import com.example.virtual_plant_pet.Presentation.screen.HomeScreen.UserScreen
import com.example.virtual_plant_pet.Presentation.screen.WildScreen.PlantsInTheWildScreen
import com.example.virtual_plant_pet.R
import com.example.virtual_plant_pet.navigation.navUtils.bottomNavigationdata
import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background4
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background5
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@Preview(showBackground = true)
@Composable
fun PreviewAppNavMap() {

    val shipList = listOf<shopItems>(
        shopItems(Image = R.drawable.shopicons, shopItem = "Thorny Armor"),
        shopItems(Image = R.drawable.shopicons, shopItem = "Root Strengthening Elixir"),
        shopItems(Image = R.drawable.shopicons, shopItem = "Water"),
        shopItems(Image = R.drawable.shopicons, shopItem = "Sunlight"),
        shopItems(Image = R.drawable.shopicons, shopItem = "Soil"),
        shopItems(Image = R.drawable.shopicons, shopItem = "Eternal Bloom"),
        shopItems(Image = R.drawable.shopicons, shopItem = "Level Boost"),
    )

    appNavMap(
        getDismiss = {},
        dismiss = true,
        getAppNavMap = {},
        shopList = shipList,
        getShopList = {},
        onQuestDismiss = true,
        getQuestDismiss = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun appNavMap(
    navController: NavHostController = rememberNavController(),
    dismiss: Boolean,
    getDismiss: (Boolean) -> Unit,
    getAppNavMap: () -> Unit,
    shopList: List<shopItems>,
    getShopList: (Int) -> Unit,
    onQuestDismiss: Boolean,
    getQuestDismiss: (Boolean) -> Unit
) {
    var showButtonSheet by remember {
        mutableStateOf(false)
    }
    val modalSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showGardenSheet by remember {
        mutableStateOf(false)
    }
    val modalGardenSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var isGameScreen by remember {
        mutableStateOf(false)
    }


    Scaffold(topBar = {
        if (!isGameScreen) {
            TopAppBar(
                title = {},
                navigationIcon = {

                    VirtualPlantScreenFeedIndicatorCircleCard(
                        modifier = Modifier
                            .widthIn(40.dp)
                            .heightIn(40.dp)
                            .clip(
                                CircleShape
                            ), getShopProduct = {
                            getShopList(it)
                        }, shopList = shopList, showButtonSheet = showButtonSheet, getShowBottomSheet = {
                            showButtonSheet = it
                        }, modalSheetState = modalSheetState
                    )

                }, actions = {
                    VirtualPlantScreenFeedUserCircleCard(
                        modifier = Modifier
                            .widthIn(40.dp)
                            .heightIn(40.dp)
                            .clip(
                                CircleShape
                            ), showGardenSheet = showGardenSheet, getGardenPlant = {}, getshowGardenSheet = {
                                showGardenSheet = it
                        }, gardenList =shopList , modalSheetState = modalGardenSheetState
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(24.dp))
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
                        .heightIn(max = 73.dp)
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
                    UserScreen(pad, onFight = {
                        navController.navigate(navScreens.gameScreens.route) {
                            popUpTo(navScreens.ProfileScreen.route) {
                                inclusive = true
                            }
                        }
                        isGameScreen = true
                    }, onSteal = {
                        navController.navigate(navScreens.gameScreens.route) {
                            popUpTo(navScreens.ProfileScreen.route) {
                                inclusive = true
                            }
                        }
                        isGameScreen = true
                    }, dismiss = dismiss, getDismiss = {
                        getDismiss(it)
                    }, shopList = shopList, getShopProduct = {
                        getShopList(it)
                    }, onQuestDismiss = onQuestDismiss, getQuestDismiss = {
                        getQuestDismiss(it)
                    })
                }
                gameNavMap(navController, pad, getAppNavMap = {
                    getAppNavMap()
                })

            }
        }
    }
}


//ShopButton
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VirtualPlantScreenFeedIndicatorCircleCard(
    modifier: Modifier, shopList: List<shopItems>, getShopProduct: (Int) -> Unit,showButtonSheet: Boolean,getShowBottomSheet: (Boolean) -> Unit,modalSheetState: SheetState
) {

    ElevatedCard(
        modifier = modifier, colors = CardDefaults.cardColors(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.mineral),
            contentDescription = "Plant",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable {
                    getShowBottomSheet(true)
                }

        )

    }
    ModalSheet(showButtonSheet=showButtonSheet, getShowBottomSheet = {
                       getShowBottomSheet(it)
    },shopList = shopList, modalSheetState =modalSheetState, getShopProduct = {
        getShopProduct(it)
    } )
//    AppNavMapIndicatorAlertBox(isVisible = isVisible, onIsVisible = {
//        isVisible = it
//    }, 100, 120, 80, 120, 110, 120, shopList = shopList, getShopProduct = {
//        getShopProduct(it)
//    }, pad = PaddingValues(20.dp))


}
//Shop Sheet
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalSheet(showButtonSheet:Boolean, getShowBottomSheet:(Boolean)->Unit, modalSheetState:SheetState, shopList: List<shopItems>, getShopProduct: (Int) -> Unit) {
    if (showButtonSheet) {
        ModalBottomSheet(
            onDismissRequest = { getShowBottomSheet(false) },
            sheetState = modalSheetState,
            dragHandle = {
                Box(modifier = Modifier.size(100.dp)){
                    Text(
                        text = "Shop",
                        modifier = Modifier
                            .widthIn(50.dp)
                            .align(Alignment.TopCenter),
                        fontSize = 25.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "DragHandle",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(top = 4.dp)
                            .align(Alignment.BottomCenter),
                        tint = Color.White
                    )

                }

            },
            containerColor = virtual_plant_background7.copy(alpha = 0.5f),
        ) {

            UserScreenSheetContent(pad = PaddingValues(20.dp), shopList =shopList, getShopProduct ={
                getShopProduct(it)
            })
        }
    }
}
//GardenSheet
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GardenModalSheet(showGardenSheet:Boolean, getshowGardenSheet:(Boolean)->Unit, modalSheetState:SheetState, gardenList: List<shopItems>, getGardenPlant: (Int) -> Unit) {
    if (showGardenSheet) {
        ModalBottomSheet(
            onDismissRequest = { getshowGardenSheet(false) },
            sheetState = modalSheetState,
            dragHandle = {
                Box(modifier = Modifier.size(100.dp)){
                    Text(
                        text = "Garden",
                        modifier = Modifier
                            .widthIn(50.dp)
                            .align(Alignment.TopCenter),
                        fontSize = 25.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "DragHandle",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(top = 4.dp)
                            .align(Alignment.BottomCenter),
                        tint = Color.White
                    )

                }
            },
            containerColor = virtual_plant_background7.copy(alpha = 0.5f),
        ) {
            AppNavMapGardenScreen(gardenList, getGardenPlant = {
                getGardenPlant(it)
            })

        }
    }
}
//GardenButton
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VirtualPlantScreenFeedUserCircleCard(
    modifier: Modifier, showGardenSheet: Boolean, getshowGardenSheet: (Boolean) -> Unit, gardenList: List<shopItems>, getGardenPlant: (Int) -> Unit,modalSheetState: SheetState
) {

    ElevatedCard(
        modifier = modifier, colors = CardDefaults.cardColors(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.garden),
            contentDescription = "Plant",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable {
                    getshowGardenSheet(true)


                }
        )

    }
    GardenModalSheet(showGardenSheet =showGardenSheet, getshowGardenSheet = {
        getshowGardenSheet(it)
    }, gardenList = gardenList, getGardenPlant = {
        getGardenPlant(it)
    }, modalSheetState = modalSheetState )



}
//GardenScreen
@Composable
fun AppNavMapGardenScreen(gardenList: List<shopItems>,getGardenPlant: (Int) -> Unit) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 100.dp),
                    userScrollEnabled = true,
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    items(gardenList) { plants ->
                        UserScreenPlantCard(plants.Image)
                    }
                }
}
//GardenPlants
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
//BottomBar
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
                        Column(
                            modifier = Modifier
                                .width(50.dp)
                                .height(60.dp),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column(
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                   .weight(4f),
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Image(
                                    painter = painterResource(id = bottomNavigationdata.icon),
                                    contentDescription = bottomNavigationdata.label,
                                    colorFilter = ColorFilter.tint(Color.Black), modifier = Modifier.weight(4f)
                                )


                            }

                            Column(
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp).weight(4f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AnimatedVisibility(
                                    visible = currentRoute == bottomNavigationdata.route,
                                enter = expandVertically(
                                    animationSpec = tween(
                                        durationMillis = 500,
                                        easing = LinearOutSlowInEasing
                                    )
                                ),
                                exit = shrinkVertically(
                                    animationSpec = tween(
                                        durationMillis = 500,
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
                        }


//                        Column(
//                            modifier = Modifier
//                                .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp),
//                            verticalArrangement = Arrangement.SpaceEvenly,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Image(
//                                painter = painterResource(id = bottomNavigationdata.icon),
//                                contentDescription = bottomNavigationdata.label,
//                                colorFilter = ColorFilter.tint(Color.Black), modifier = Modifier.weight(4f)
//                            )
//                            AnimatedVisibility(
//                                visible = currentRoute == bottomNavigationdata.route,
//                                enter = expandVertically(
//                                    animationSpec = tween(
//                                        durationMillis = 300,
//                                        easing = LinearOutSlowInEasing
//                                    )
//                                ),
//                                exit = shrinkVertically(
//                                    animationSpec = tween(
//                                        durationMillis = 300,
//                                        easing = LinearOutSlowInEasing
//                                    )
//                                ), modifier =
//                                Modifier.weight(4f)
//                            ) {
//
//                                Text(
//                                    text = bottomNavigationdata.label,
//                                    fontSize = 10.sp,
//                                    color = Color.Black,
//                                    fontFamily = fontFamily
//                                )
//                            }
//                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        Color.Black,
                        indicatorColor = Color.White
                    ),

                    )
            }
    }
}
//ShopScreen
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
//TOUSE-----

