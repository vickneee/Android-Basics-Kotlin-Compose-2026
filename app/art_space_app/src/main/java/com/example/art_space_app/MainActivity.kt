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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var currentIndex by remember { mutableIntStateOf(0) }

    val artworks = listOf(
        R.drawable.pexels_oandremoura_9083011,
        R.drawable.pexels_anniroenkae_2983141,
        R.drawable.pexels_mccutcheon_1149019,
        R.drawable.pexels_anniroenkae_3109830
    )

    // Blue Red and White Light on Dark Background Andre Moura 2021
    // Close-Up Photo Of Abstract Paint Anni Roenkae 2019
    // Multicolored Abstract Artwork Alexander Grey 2018
    // Multicolored Illustration Anni Roenkae 2019

    val titles = listOf(
        "Blue Red and White Light on Dark Background",
        "Close-Up Photo Of Abstract Paint",
        "Multicolored Abstract Artwork",
        "Multicolored Illustration"
    )

    val artists = listOf(
        "Andre Moura",
        "Anni Roenkae",
        "Alexander Grey",
        "Anni Roenkae"
    )

    val years = listOf(
        "2021",
        "2019",
        "2018",
        "2019"
    )

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
                        Image(
                            painter = painterResource(id = artworks[currentIndex]),
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
                        text = titles[currentIndex],
                        modifier = modifier,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(artists[currentIndex])
                            }
                            append(" (${years[currentIndex]})")
                        },
                        modifier = modifier,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }

            // Buttons
            Row(
                modifier = modifier
                    .padding(18.dp, 10.dp, 20.dp, 1.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = {
                        if (currentIndex > 0) {
                            currentIndex--
                        } else {
                            currentIndex = artworks.size - 1
    }
                    }, modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Previous", modifier = Modifier.padding(28.dp, 0.dp))
                }

                Button(
                    onClick = {
                        if (currentIndex < artworks.size - 1) {
                            currentIndex++
                        } else {
                            currentIndex = 0
                        }
                    }, modifier = Modifier.padding(8.dp)
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