package com.example.habits2.methods

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun getCurrentDate(): Date {
    val calendar = Calendar.getInstance()
    return calendar.time
}

fun getFormattedDate(date: Date, format: String): String {
    val formatter = SimpleDateFormat(format)
    return formatter.format(date)
}

fun getPastOrFutureDate(days: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, days)
    return calendar.time
}