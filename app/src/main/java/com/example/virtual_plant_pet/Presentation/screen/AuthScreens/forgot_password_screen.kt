package com.example.virtual_plant_pet.Presentation.screen.AuthScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3


@Composable
fun ForgotPasswordScreen(modifier:Modifier=Modifier,onForgot:()->Unit,forgotPassword:String,onForgotPassword:(String)->Unit) {
    Box(
        modifier = modifier
    ) {
        ElevatedCard(
            modifier = Modifier
                .padding(24.dp)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color.Gray,
                    shape = RoundedCornerShape(
                        16.dp
                    )
                )
                .border(
                    border = BorderStroke(0.2.dp, Color.Gray), shape = RoundedCornerShape(
                        16.dp
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight(.25f)
                .clip(
                    RoundedCornerShape(
                        16.dp
                    )
                )
                .align(Alignment.Center), colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.size(5.dp))


                Text(
                    text = "Please Enter Your Email",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(5.dp))

                OutlinedTextField(
                    value = forgotPassword,
                    onValueChange = {
                      onForgotPassword(it)
                    },
                    Modifier
                        .widthIn(300.dp)
                        .heightIn(60.dp)
                        .background(
                            Color.Transparent
                        ),
                    label = {
                        Text(text = "Your Email...", color = Color.Black.copy(alpha = 0.6f))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        focusedContainerColor = Color.Black.copy(alpha = 0.2f)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Pets,
                            contentDescription = "Pet Name",
                            tint = Color.Black
                        )
                    })

                Spacer(modifier = Modifier.size(12.dp))

                ButtonScreen(
                    value = "Done",
                    onClick = { onForgot()},
                    height = 60.dp,
                    width = 300.dp
                )
                Spacer(modifier = Modifier.size(5.dp))
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    ForgotPasswordScreen(onForgot =
    {}, forgotPassword = "", onForgotPassword = {})
}
