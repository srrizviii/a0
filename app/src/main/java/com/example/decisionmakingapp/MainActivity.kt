package com.example.decisionmakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decisionmakingapp.ui.theme.DecisionMakingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionMakingAppTheme {
                DecisonMakingApp()
            }
        }
    }
}

@Preview
@Composable
fun DecisonMakingApp() {
    DecisionButtonsAndMessage()

}

@Composable
fun DecisionButtonsAndMessage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    var clickCount by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf(0) }

    val textResult = when (result) {
        1 -> "Yes"
        2 -> "No"
        else -> "Should we go?"
    }

    val TextColor = when (result) {
        1 -> Color.Green
        2 -> Color.Red
        else -> Color.Gray
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(textResult, fontSize = 40.sp, color = TextColor)

        Row(modifier = Modifier.padding(8.dp)) {
            Button(onClick = {
                clickCount++
                result = if ((1..100).random() <= 50) 1 else 2
            }) {
                Text("I guess bro")
            }
            Button(onClick = {
                clickCount++
                result = if ((1..100).random() <= 25) 1 else 2

            }) {
                Text("Not really tbh")
            }
            Button(onClick = {
                clickCount++
                result = if ((1..100).random() <= 10) 1 else 2
            }) {
                Text("Nah bro 😭")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Click count: $clickCount")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                result = 0
                clickCount = 0
            }
        ) {
            Text("Reset")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text("Made by Rayan Rizvi (1800947, srrizvi)", fontSize = 10.sp, color = Color.Blue)


    }

}