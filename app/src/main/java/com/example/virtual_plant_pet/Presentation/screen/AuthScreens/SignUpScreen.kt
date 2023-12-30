package com.example.virtual_plant_pet.Presentation.screen.AuthScreens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solus.authScreens.authUtils.MyCircle
import com.example.virtual_plant_pet.Presentation.screen.AuthScreens.AuthUtils.SignUpAuthData
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.ButtonScreen
import com.example.virtual_plant_pet.Presentation.screen.ScreenUtils.TextScreen
import com.example.virtual_plant_pet.R

import com.example.virtual_plant_pet.ui.theme.fontFamily
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background3
import com.example.virtual_plant_pet.ui.theme.virtual_plant_background7


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        signUpAuthData = SignUpAuthData(
            email = "",
            password = "",
            confirmPassword = "",
            getConfirmPassword = {},
            getPassword = {},
            getEmail = {},
            getGoogleSignUp = {},
            getPasswordExpose = {},
            getPasswordExpose2 = {},
            getSignUpPasswordExpose = false,
            facebookSignUp = {},
            onSignUpNavigate = {},
            getSignUpPasswordExpose2 = false, onLoginInNavigate = {}
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(modifier: Modifier = Modifier, signUpAuthData: SignUpAuthData) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.niwaicon),
                contentDescription = "solus",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = signUpAuthData.email,
                onValueChange = {
                    signUpAuthData.getEmail(it)
                },
                Modifier
                    .widthIn(300.dp)
                    .heightIn(60.dp)
                    .background(
                        Color.Transparent
                    ),
                label = {
                    Text(text = "Email", color = Color.Black)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    focusedContainerColor = Color.Black.copy(alpha = 0.2f)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email",
                        tint = Color.Black
                    )
                }, textStyle = TextStyle(Color.Black)
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = signUpAuthData.password,
                onValueChange = {
                    signUpAuthData.getPassword(it)
                },
                Modifier
                    .widthIn(300.dp)
                    .heightIn(60.dp)
                    .background(
                        Color.Transparent
                    ),
                label = {
                    Text(text = "Password", color = Color.Black)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    focusedContainerColor = Color.Black.copy(alpha = 0.2f)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Password",
                        tint = Color.Black
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (signUpAuthData.getSignUpPasswordExpose) {
                            Icons.Filled.Visibility
                        } else {
                            Icons.Filled.VisibilityOff
                        },
                        contentDescription = "Password",
                        modifier = Modifier.clickable { signUpAuthData.getPasswordExpose(!signUpAuthData.getSignUpPasswordExpose) },
                        tint = Color.Black
                    )
                },
                visualTransformation = if (signUpAuthData.getSignUpPasswordExpose) VisualTransformation
                    .None else PasswordVisualTransformation(), textStyle = TextStyle(Color.Black)
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = signUpAuthData.confirmPassword,
                onValueChange = {
                    signUpAuthData.getConfirmPassword(it)
                },
                Modifier
                    .widthIn(300.dp)
                    .heightIn(60.dp)
                    .background(
                        Color.Transparent
                    ),
                label = {
                    Text(text = "Confirm Password", color = Color.Black)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    focusedContainerColor = Color.Black.copy(alpha = 0.2f)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Password",
                        tint = Color.Black
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (signUpAuthData.getSignUpPasswordExpose2) {
                            Icons.Filled.Visibility
                        } else {
                            Icons.Filled.VisibilityOff
                        },
                        contentDescription = "Password",
                        modifier = Modifier.clickable { signUpAuthData.getPasswordExpose2(!signUpAuthData.getSignUpPasswordExpose2) },
                        tint = Color.Black
                    )
                },
                visualTransformation = if (signUpAuthData.getSignUpPasswordExpose2) VisualTransformation
                    .None else PasswordVisualTransformation(), textStyle = TextStyle(Color.Black)
            )
            Spacer(modifier = Modifier.size(16.dp))

            Spacer(modifier = Modifier.size(28.dp))
            ButtonScreen(
                value = "Sign Up",
                onClick = { signUpAuthData.onSignUpNavigate() },
                height = 60.dp,
                width = 300.dp
            )
            Spacer(modifier = Modifier.size(32.dp))
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

            Spacer(modifier = Modifier.size(16.dp))
            Row {
                OutlinedCard(
                    modifier = Modifier
                        .size(width = 100.dp, height = 40.dp)
                        .clickable {
                            signUpAuthData.getGoogleSignUp()
                        },
                    shape = CardDefaults.outlinedShape,
                    colors = CardDefaults.outlinedCardColors(virtual_plant_background7),
                    border = CardDefaults.outlinedCardBorder(true)
                ) {
                    Spacer(modifier = Modifier.size(8.dp))
                    Image(
                        modifier = Modifier.size(width = 100.dp, height = 20.dp),
                        painter = painterResource(id = R.drawable.facebookicon),
                        contentDescription = "Google Auth",
                        alignment = Alignment.Center,
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                OutlinedCard(
                    modifier = Modifier
                        .size(width = 100.dp, height = 40.dp)
                        .clickable {
                            signUpAuthData.facebookSignUp()
                        },
                    shape = CardDefaults.outlinedShape,
                    colors = CardDefaults.outlinedCardColors(virtual_plant_background7),
                    border = CardDefaults.outlinedCardBorder(true)
                ) {
                    Spacer(modifier = Modifier.size(8.dp))
                    Image(
                        modifier = Modifier.size(width = 100.dp, height = 20.dp),
                        painter = painterResource(id = R.drawable.facebookicon),
                        contentDescription = "Facebook Auth",
                        alignment = Alignment.Center,
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
            Spacer(modifier = Modifier.size(40.dp))
            Row {
                TextScreen(value = "Already Have An Account?", font = 16)
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Login In",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = fontFamily,
                    modifier = Modifier.clickable { signUpAuthData.onLoginInNavigate() })
            }

        }
    }
}