package com.example.perjantai_13

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.perjantai_13.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("XYZ", "onCreate()")

        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            Greeting(
                name = "Android",
                modifier = Modifier
            )
        }
    }

    override fun onStart() {

        Log.d("XYZ", "onStart()")
        super.onStart()
    }

    override fun onResume() {

        Log.d("XYZ", "onResume()")
        super.onResume()
    }

    override fun onPause() {

        Log.d("XYZ", "onPause()")
        super.onPause()
    }

    override fun onStop() {

        Log.d("XYZ", "onStop()")
        super.onStop()
    }

    override fun onDestroy() {

        Log.d("XYZ", "onDestroy()")
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        Greeting("Android")
    }
}