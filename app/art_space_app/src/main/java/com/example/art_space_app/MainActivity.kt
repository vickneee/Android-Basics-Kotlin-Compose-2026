package com.example.art_space_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space_app.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        ArtSpaceApp()
                    }
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {

    Box(
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image Card
            Box(
                modifier = modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    color = Color.LightGray,
                    shadowElevation = 6.dp
                ) {
                    Row(
                        modifier = modifier
                            .background(Color.White)
                            .height(500.dp)
                            .width(350.dp)
                    )
                    {
                        // Blue Bird Perched on Wire Against Clear Sky Jagaba Denis
                        // Close-up of Leaf with Water Droplets in Black and White Jonathan Borba
                        Image(
                            painter = painterResource(R.drawable.pexels_oandremoura_9083011),
                            contentDescription = null,
                            modifier = modifier
                                .padding(28.dp)
                                .fillMaxSize()
                        )
                    }
                }
            }

            // Text Card
            Row(
                modifier = modifier
                    .border(2.dp, Color.LightGray)
                    .width(350.dp)
                    .background(
                        color = Color.LightGray
                    )
            )
            {
                Column(
                    modifier = modifier.padding(18.dp),
                    horizontalAlignment = Alignment.Start
                )
                {
                    Text(
                        text = "Blue Red and White Light on Dark Background",
                        modifier = modifier,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Andre Moura")
                            }
                            append("(2021)")
                        }
                    )
                }
            }

            // Buttons
            Row(
                modifier = modifier.padding(top = 18.dp)
                    .width(350.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Previous", modifier = Modifier.padding(28.dp, 0.dp))
                }
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Next",
                        modifier = Modifier.padding(28.dp, 0.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    AndroidBasicsKotlinCompose2026Theme {
        ArtSpaceApp()
    }
}