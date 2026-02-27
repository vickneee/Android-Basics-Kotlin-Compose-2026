package com.example.lotto_27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lotto_27.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                LottoScreen()
            }
        }
    }
}

@Composable
fun LottoScreen() {

}

@Composable
fun LottoPlay() {

}

@Composable
fun LottoControls() {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        LottoScreen()
    }
}