package com.example.exposeddropdownmenuboxsample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exposeddropdownmenuboxsample.ui.theme.ExposedDropDownMenuBoxSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> ExposedDropDownMenuBox(
    items: List<T>,
    selectedText: String,
    modifier: Modifier = Modifier,
    onSelectItem: (T) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier,
    ) {
        TextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor(),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onSelectItem(item)
                        expanded = false
                    },
                    text = {
                        Text(
                            text = item.toString(),
                            style = MaterialTheme.typography.headlineSmall,
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExposedDropDownMenuBoxPreview() {
    ExposedDropDownMenuBoxSampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val items = listOf("東京", "神奈川", "千葉", "埼玉")
            ExposedDropDownMenuBox(
                items = items,
                selectedText = items[0]
            )
        }
    }
}