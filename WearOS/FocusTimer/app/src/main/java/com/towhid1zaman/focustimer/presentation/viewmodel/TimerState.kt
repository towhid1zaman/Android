package com.towhid1zaman.focustimer.presentation.viewmodel

data class TimerState (
    val isRunning: Boolean =  false,
    val timeLeftMillis: Long = 25*60*100L, // default 25 minutes
    val totalTimeMillis: Long = 25*60*1000L,
    val isFinished: Boolean = false,
    val isPaused: Boolean = false
)
/*
Property and Purpose for better understanding, will delete later :)

isRunning	    Whether the timer is actively counting,
timeLeftMillis	Milliseconds left on the countdown,
totalTimeMillis	Full time at the start (useful for percent progress),
isFinished	    True when countdown reaches 0,
isPaused	    Whether the user has paused the timer
 */