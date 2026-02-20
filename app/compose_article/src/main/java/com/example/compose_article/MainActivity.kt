package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article.ui.theme.AndroidBasicsKotlinCompose2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsKotlinCompose2026Theme {
                Surface(
                    modifier = Modifier
                        .systemBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundImage(
                        header = "Jetpack Compose tutorial",
                        firstCol = "Jetpack Compose is a modern toolkit for building native Android " +
                                "UI. Compose simplifies and accelerates UI development on Android " +
                                "with less code, powerful tools, and intuitive Kotlin APIs.",
                        secondCol = "In this tutorial, you build a simple UI component with " +
                                "declarative functions. You call Compose functions to say what " +
                                "elements you want and the Compose compiler does the rest. Compose " +
                                "is built around Composable functions. These functions let" +
                                " you define your app's UI programmatically because they let you describe how it" +
                                " should look and provide data dependencies, rather than focus on the process of" +
                                " the UI's construction, such as initializing an element and then attaching it to" +
                                " a parent. To create a Composable function, you add the @Composable annotation to" +
                                " the function name."
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleScreen(
    header: String,
    firstCol: String,
    secondCol: String,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
        Text(
            text = header, // "Jetpack Compose tutorial",
            fontSize = 24.sp,
        )
        Text(
            text = firstCol,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = secondCol,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun BackgroundImage(
    header: String,
    firstCol: String,
    secondCol: String
) {
    Column {
        val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        ArticleScreen(
            header = header,
            firstCol = firstCol,
            secondCol = secondCol
        )
    }
}

