package com.example.exposeddropdownmenuboxsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exposeddropdownmenuboxsample.ui.theme.ExposedDropDownMenuBoxSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExposedDropDownMenuBoxSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val items = listOf("東京", "神奈川", "千葉", "埼玉")
                    var selectedText by remember { mutableStateOf(items.first()) }
                    ExposedDropDownMenuBox(
                        items = items,
                        selectedText = selectedText,
                        onSelectItem = {
                            selectedText = it
                        },
                    )
                }
            }
        }
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
    ExposedDropDownMenuBoxSampleTheme {
        Greeting("Android")
    }
}