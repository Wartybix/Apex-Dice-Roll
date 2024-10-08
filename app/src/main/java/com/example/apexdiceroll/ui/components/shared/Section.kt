package com.example.apexdiceroll.ui.components.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Section(
    title: String = "",
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surfaceContainer,
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Surface(
        shape = CardDefaults.shape,
        color = color,
        contentColor = contentColor,
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (title != "") {
                Text(text = title, style = MaterialTheme.typography.titleSmall)

                Spacer(modifier = Modifier.size(8.dp))
            }

            content()
        }
    }
}

@Preview
@Composable
fun SectionPreview() {
    Section(
        title = "My Section", content = {
            Text("Hi there", style = MaterialTheme.typography.titleLarge)
        }
    )
}

@Preview
@Composable
fun SectionPreviewNoTitleTertiary() {
    Section(
        content = {
            Text(text = "Yep")
        },
        color = MaterialTheme.colorScheme.tertiaryContainer
    )
}