package com.example.monday_23

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monday_23.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ModifyText(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ModifyText(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") } // Kuin static Javassa
    // var text = "Huh Hei"
    Column(
        modifier = modifier
            .padding(36.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Greeting(
            name = text,
            modifier = Modifier
        )
        TextField(
            value = text,
            onValueChange = { text = it; Log.i("JV", "Arvo on $it") },
            label = { Text(stringResource(R.string.enter_name)) },
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Log.i("JV", "Greeting arvo on $name")
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        ModifyText()
    }
}
