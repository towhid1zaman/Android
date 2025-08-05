package com.towhid1zaman.focustimer.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.towhid1zaman.focustimer.presentation.domain.model.SessionType
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _timerState = MutableStateFlow(TimerState())
    val timerState = _timerState.asStateFlow()

    private var timerJob: Job? = null

    fun startTimer(onTimerFinished: () -> Unit = {}) {  // Added callback
        // Starts a new coroutine and saves its reference in timerJob
        if (_timerState.value.isRunning) return
        Log.d("TIMER", "Timer started")

        _timerState.value = _timerState.value.copy(
            isRunning = true,
            isPaused = false,
            isFinished = false
        )

        timerJob = viewModelScope.launch {
            /*
            Launches a coroutine in viewModelScope (tied to ViewModel lifecycle).
            Coroutine loops every second (delay(1000L)): Decrements timeLeftMillis by 1000 (1 second).
            */

            while (_timerState.value.timeLeftMillis > 0) {
                delay(1000L) // Wait 1 seconds

                _timerState.value = _timerState.value.copy(
                    timeLeftMillis = _timerState.value.timeLeftMillis - 1000L
                )
            }
            // When time reaches zero,
            //Sets isRunning = false and isFinished = true — timer done
            _timerState.value = _timerState.value.copy(
                isRunning =  false,
                isFinished = true
            )

            onTimerFinished() // Callback to UI for vibration
        }
    }

    fun pauseTimer() { // Calls timerJob?.cancel() to stop the countdown coroutine
        timerJob?.cancel() //Stop the coroutine counting down
        _timerState.value = _timerState.value.copy(
            isRunning = false,
            isPaused = true
        )
    }

    fun resetTimer() { // Also cancels the countdown coroutine and resets state
        timerJob?.cancel()
        _timerState.value = TimerState() // resets to default
    }

    fun setSession(sessionType: SessionType) {
        timerJob?.cancel() // cancel running if switching
        _timerState.value = TimerState(
            timeLeftMillis = sessionType.durationMillis,
            sessionType = sessionType
        )
    }
}


/*
Explanation, I'll remove later :)

1. Class
I have created a class TimerViewModel that inherits from Android's ViewModel class.
ViewModel helps hold UI-related data that survives configuration changes (like screen rotation).

2. About _timerState
_timerState is a mutable reactive data holder (a StateFlow) initialized with default TimerState (25 min, not running).
Private because only TimerViewModel can modify it.

3. About timerState
This exposes the state to UI as an immutable/read-only flow.
UI observes timerState to get updates but cannot change it directly.

4. About timerJobs
Holds the coroutine job that counts down the timer.
I keep a reference so I can cancel it when pausing or resetting.

A coroutine is a lightweight thread in kotlin that lets you do work asynchronously (i,e. in the background) without
blocking the main UI thread.
A job is a handle or reference to a coroutine,

Think like this,
Croutine is a running engine.
Job is remote control - we can cancel, pause, or inspect the coroutine through it.

Imagine:
Coroutine = stopwatch counting down
Job = the stop button

If you don’t have the stop button, the stopwatch never stops — even if you leave the screen!

It allows us to control the lifecycle of the coroutine (start, pause, stop)
Prevents multiple timers from running at the same time
Keeps the app memory-safe and accurate


 */