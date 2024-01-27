package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier
                .background(color = Color(0xFF98939C))
                .fillMaxSize()){

                Canvas(modifier = Modifier
                    .fillMaxWidth()) {
                    drawRoundRect(
                        color = Color(0xFF8048A8),
                        size = Size(width = 384.dp.toPx() , height =300.dp.toPx() ),

                        cornerRadius = CornerRadius(x = 26.dp.toPx(), y = 26.dp.toPx())
                    )


                }
                MyUI()


            }
    }
}

    @Composable
    fun MyUI() {
        Box {
            Canvas(
                modifier = Modifier
                    .size(size = 300.dp)

            ) {
                drawRoundRect(

                    color = Color(0xFFCBCBCC),
                    size = Size(width = 340.dp.toPx(), height = 360.dp.toPx()),
                    cornerRadius = CornerRadius(x = 26.dp.toPx(), y = 36.dp.toPx()),
                    topLeft = Offset(x = 22.dp.toPx(), y = 91.dp.toPx())
                )

            }
            Column{
                Text(text = "Log In",
                    modifier = Modifier
                        .offset(x=100.dp,y=84.dp),
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                EmailText()
                NumberText()
                PassText()
                Butt {

                }
                Text(text="New User?",
                    modifier = Modifier
                        .offset(x=140.dp,y=233.dp))
                TextButt {

                }


            }

        }
    }
    @Composable
    fun TextButt(onClick: () -> Unit) {
        TextButton(
            onClick = { onClick()  }, modifier = Modifier
                .offset(x=200.dp,y=200.dp)
        ) {
            Text("Sign up")
        }
    }
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    private fun EmailText() {
        var value by remember {
            mutableStateOf("")
        }

        val context = LocalContext.current.applicationContext
        val keyboardController = LocalSoftwareKeyboardController.current

        TextField(
            modifier = Modifier
                .offset(x=50.dp,y=93.dp),
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Enter your Email ID") },

            keyboardActions = KeyboardActions(
                onSearch = {

                    keyboardController?.hide()

                }
            )
        )
    }
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    private fun NumberText() {
        var value by remember {
            mutableStateOf("")
        }

        val context = LocalContext.current.applicationContext
        val keyboardController = LocalSoftwareKeyboardController.current

        TextField(
            modifier = Modifier
                .offset(x=50.dp,y=103.dp),
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            label = { Text(text = "Phone") },
            placeholder = { Text(text = "Enter your Phone number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()


                }
            )
        )
    }
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    private fun PassText() {
        var value by remember {
            mutableStateOf("")
        }

        val context = LocalContext.current.applicationContext
        val keyboardController = LocalSoftwareKeyboardController.current

        TextField(
            modifier = Modifier
                .offset(x=50.dp,y=113.dp),
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter your Password") },

            keyboardActions = KeyboardActions(
                onSearch = {

                    keyboardController?.hide()

                }
            )
        )
    }
    @Composable
    fun Butt(onClick: () -> Unit) {
        Button(
            onClick = { onClick() }, modifier = Modifier
                .offset(x = 50.dp, y = 133.dp)
                .size(width = 280.dp, height = 40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF891AD8),
            )
        ) {
            Text(text = "Log In")
        }
    }}