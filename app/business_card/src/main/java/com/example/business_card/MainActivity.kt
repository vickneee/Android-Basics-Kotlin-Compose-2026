package com.example.business_card

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        color = Color(0xFF3F5279)
                    ) {
                        BusinessCardApp()
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("JV", "onStop fun called")
    }
}

@Composable
fun BusinessCardApp() {
    Row {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FirstSection()
            SecondSection()
        }
    }
}

@Composable
fun FirstSection() {
    val image = painterResource(R.drawable.android_logo)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.size(100.dp), // fixed size
    )
    Text(
        text = stringResource(R.string.name),
        fontSize = 38.sp
    )
    Text(
        text = stringResource(R.string.title),
        fontSize = 16.sp
    )
}

@Composable
fun SecondSection() {
    Text(
        text = "+(358) 124 124 2345",
        fontSize = 16.sp
    )
    Text(
        text = "@AndroidDev",
        fontSize = 16.sp
    )
    Text(
        text = "vic.vav@android.dev",
        fontSize = 16.sp
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        BusinessCardApp()
    }
}