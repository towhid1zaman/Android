package com.towhid1zaman.focustimer.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.towhid1zaman.focustimer.presentation.domain.model.SessionType

@Composable
fun SessionTypeSelector(
    selectedSession: SessionType,
    onSessionSelected: (SessionType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, start = 5.dp, end = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SessionType.entries.forEach { session ->
            Button(
                onClick = { onSessionSelected(session) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (session == selectedSession) Color.Blue else Color.Gray
                ),
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(text = session.displayName)
            }
        }
    }
}