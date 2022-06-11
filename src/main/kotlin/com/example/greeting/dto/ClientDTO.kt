package com.example.greeting.dto

data class ClientDTO(
    val mail: String,
    var firstName: String,
    var lastName: String,
    var gender: String,
    var birthday: String // format yyyy/M/d
)
