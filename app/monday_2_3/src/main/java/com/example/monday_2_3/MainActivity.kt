package com.example.monday_2_3

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.monday_2_3.ui.theme.AndroidBasicsKotlinCompose2026Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val urlText = URL("https://users.metropolia.fi/~jarkkov/koe.txt")
        val urlImage = URL("https://users.metropolia.fi/~jarkkov/folderimage.jpg")
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    ShowAll(
                        urlTextAddress = urlText,
                        urlText = urlText,
                        urlImageAddress = urlImage,
                        urlImage = urlImage,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowAll(
    urlTextAddress: URL,
    urlText: URL,
    urlImageAddress: URL,
    urlImage: URL,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PrintTextAddress(urlTextAddress)
        ShowText(urlText)
        PrintImageAddress(urlImageAddress)
        ShowImage(urlImage)
    }
}

@Composable
fun PrintTextAddress(url: URL) {
    Text("URL: $url")
}

@Composable
fun PrintImageAddress(url: URL) {
    Text("URL: $url")
}

@Composable
fun ShowText(
    urlText: URL,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }

    // LaunchedEffect is used to launch a coroutine when the URL changes
    LaunchedEffect(urlText) {
        text = getText(urlText)
    }
    Text(text,
        fontSize = 18.sp,
        modifier = modifier
    )
}

@Composable
fun ShowImage(
    urlImage: URL,
    modifier: Modifier = Modifier
) {
    // MutableState<ImageBitmap?> is used to store the image
    var image by remember { mutableStateOf<ImageBitmap?>(null) }

    // LaunchedEffect is used to launch a coroutine when the URL changes
    LaunchedEffect(urlImage) {
        image = getImage(urlImage)
    }
    // Image object can be null
    image?.let {
        Image(
            it,
            contentDescription = null,
            modifier = modifier
        )
    }
}

// Reads a file
private suspend fun getText(url: URL): String =
    withContext(Dispatchers.IO) {
        return@withContext url.readText()
    }

// Reads an image
private suspend fun getImage(url: URL): ImageBitmap =
    withContext(Dispatchers.IO) {
        val stream = url.openStream()
        val bitmap = BitmapFactory.decodeStream(stream)
        stream.close()
        return@withContext bitmap.asImageBitmap()
    }

@Preview(showBackground = true)
@Composable
fun ShowTextPreview() {
    AndroidBasicsKotlinCompose2026Theme {
        ShowText(URL("Preview Text"))
    }
}