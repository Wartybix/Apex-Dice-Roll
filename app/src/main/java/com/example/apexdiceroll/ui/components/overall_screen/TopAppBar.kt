package com.example.apexdiceroll.ui.components.overall_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(title = {
        Row {
            Text(text = "Apex", fontWeight = FontWeight.Bold)
            Text(text = " | Dice Roll")
        }
    })
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}