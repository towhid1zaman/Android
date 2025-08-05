package com.towhid1zaman.focustimer.presentation.ui.screens

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.towhid1zaman.focustimer.presentation.ui.components.CircularTimer
import com.towhid1zaman.focustimer.presentation.ui.components.SessionTypeSelector
import com.towhid1zaman.focustimer.presentation.ui.components.TimerControls
import com.towhid1zaman.focustimer.presentation.util.formatTime
import com.towhid1zaman.focustimer.presentation.util.VibrationHelper
import com.towhid1zaman.focustimer.presentation.viewmodel.TimerViewModel

@Composable
fun TimerScreen(viewModel: TimerViewModel = viewModel()) {
    val timerState by viewModel.timerState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SessionTypeSelector(
         selectedSession = timerState.sessionType,
            onSessionSelected = {
                session ->
                viewModel.setSession(session)
            }
        )

        CircularTimer(
            progress = viewModel.getProgress(),
            timeText = formatTime(timerState.timeLeftMillis)
        )
        // Adds vertical space between the timer and the buttons
        //Spacer(modifier = Modifier.height(8.dp))
        val context = LocalContext.current
        TimerControls(
            timerState = timerState,
            onStart = {
                viewModel.startTimer{
                    VibrationHelper.vibrate(context)
                }
            },
            onPause = {viewModel.pauseTimer()},
            onReset = {viewModel.resetTimer()}
        )
    }
}



/*
This is the UI layer in MVVM — the View.
It:
    Collects state from TimerViewModel
    Displays the timer value (MM:SS)
    Has buttons for Start / Pause / Reset

TimerScreen(...): This is the screen function, like an XML layout but in Kotlin.
viewModel() gives  a TimerViewModel instance, so we can access timer data and logic.


timerState is a StateFlow in the ViewModel.
    collectAsState() turns it into a Compose-friendly state.
    by means we automatically update the UI when timerState changes.
    So, whenever time ticks (every second), the UI will automatically recompose.

Column arranges items vertically.
    fillMaxSize() makes it take full screen.
    padding(16.dp) adds space around it.
    Arrangement.Center aligns children vertically center.
    Alignment.CenterHorizontally centers items horizontally.

Row {} puts buttons side by side
    Each Button() calls a ViewModel function
    enabled = decides if the button is clickable or not based on current state
        e.g. Don’t allow "Start" when already running

 */