package com.example.greeting.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class GreetingDTO(
    val subject: String,
    val content: String,
    var filePath: String? = null
)
