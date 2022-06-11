package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO

interface MessageService {

    fun greetingBirthday(clients: List<ClientDTO>): List<GreetingDTO>
}