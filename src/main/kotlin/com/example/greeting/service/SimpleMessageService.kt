package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO
import org.springframework.stereotype.Service

@Service("simple")
class SimpleMessageService: MessageService {

    private val subject = "Subject: Happy birthday!\n"
    private val content = "Happy birthday, dear %s!\n"

    override fun greetingBirthday(clients: List<ClientDTO>): List<GreetingDTO> {
        return clients.map { GreetingDTO(subject, content.format(it.firstName)) }
    }
}