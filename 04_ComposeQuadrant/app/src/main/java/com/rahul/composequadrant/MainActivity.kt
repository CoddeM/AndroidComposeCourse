package com.rahul.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahul.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant(
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                title = "Text Composable",
                desc = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f),
                bgColor = Color(0xFFEADDFF)
            )
            Quadrant(
                title = "Image Composable",
                desc = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f),
                bgColor = Color(0xFFD0BCFF)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                title = "Row Composable",
                desc = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f),
                bgColor = Color(0xFFB69DF8)
            )
            Quadrant(
                title = "Column Composable",
                desc = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f),
                bgColor = Color(0xFFF6EDFF)
            )
        }
    }
}


@Preview
@Composable
fun Quadrant(
    title: String = "Text Composable",
    desc: String = "Displays text and follows the recommended Material Design guidelines.",
    modifier: Modifier = Modifier,
    bgColor: Color = Color(0xFFEADDFF)
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )
    }

}


@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}