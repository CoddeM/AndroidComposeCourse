package com.rahul.a07_lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahul.a07_lemonadeapp.ui.theme._07_LemonadeAppTheme
import kotlin.inc

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _07_LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp(){
    Column {
        Spacer(modifier = Modifier.height(24 .dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(color = Color.Yellow),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "Lemonade App",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopCenter),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }
        LemonadeImageAndText(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}

@Composable
fun LemonadeImageAndText(modifier: Modifier = Modifier){
    var count by remember { mutableStateOf(0) }
    var touchCOunt by remember { mutableStateOf(0) }
    var targetCount by remember { mutableStateOf((2..4).random()) }

    val image = when (count){
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val text = when (count){
        0 -> "Tap the lemon tree to select a lemon"
        1 -> "Keep tapping the lemon to squeeze it"
        2 -> "Tap the lemonade to drink it"
        else -> "Tap the empty glass to start again"
    }

    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally
    ) {
        Button (onClick = {
            when(count){
                0 -> {
                    count = 1
                }
                1 -> {
                    touchCOunt++
                    if (touchCOunt >= targetCount){
                        count = 2
                        touchCOunt = 0
                        targetCount = (2..4).random()
                    }
                }
                2 -> {
                    count = 3
                }
                else -> {
                    count = 0
                }
            }
        }){
            Image(painter = painterResource(id = image), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = text, fontSize = 18.sp)
    }
}
