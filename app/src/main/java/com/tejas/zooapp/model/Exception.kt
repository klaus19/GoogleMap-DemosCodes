package com.tejas.zooapp.model

data class Exception(
    val endDate: String,
    val exceptionHours: ExceptionHours,
    val name: String,
    val startDate: String
)