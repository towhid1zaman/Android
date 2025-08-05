package com.towhid1zaman.focustimer.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircularTimer(
    progress: Float,
    timeText: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size( width = 120.dp, height = 40.dp)
    ) {
//        CircularProgressIndicator(
//            progress = { progress },
//            modifier = Modifier.fillMaxSize(),
//            strokeWidth = 10.dp
//        )
        LinearProgressIndicator(
            progress = { progress }
        )

        Text(
            text = timeText,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
