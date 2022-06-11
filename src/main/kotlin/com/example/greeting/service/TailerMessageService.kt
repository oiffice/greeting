package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO
import org.springframework.stereotype.Service

@Service("tailer")
class TailerMessageService: MessageService {

    override fun greetingBirthday(clients: List<ClientDTO>): List<GreetingDTO> {
        TODO("Not yet implemented")
    }
}