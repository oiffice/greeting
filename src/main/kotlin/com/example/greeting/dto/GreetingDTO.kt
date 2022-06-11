package com.example.greeting.dto

data class GreetingDTO(
    val subject: String,
    val content: String,
    var filePath: String? = null
)
