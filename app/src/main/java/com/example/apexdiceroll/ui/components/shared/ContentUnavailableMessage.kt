package com.example.apexdiceroll.ui.components.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContentUnavailableMessage(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    text: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = imageVector, contentDescription = null, modifier = Modifier.size(64.dp))
        
        Spacer(modifier = Modifier.size(16.dp))
        
        Text(text = text, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun ContentUnavailableMessagePreview() {
    ContentUnavailableMessage(
        imageVector = Icons.Outlined.Info,
        text = "Content is unavailable"
    )
}