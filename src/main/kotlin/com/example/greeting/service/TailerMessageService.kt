package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO
import com.example.greeting.repository.TailerMessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("tailer")
class TailerMessageService: MessageService {

    private val subject = "Subject: Happy birthday!\n"
    private val content = "Happy birthday, dear %s!\n"

    @Autowired
    private lateinit var tailerMessageRepository: TailerMessageRepository

    override fun greetingBirthday(clients: List<ClientDTO>): List<GreetingDTO> {
        return clients.groupBy { it.gender.lowercase() }
            .map { (gender, clients) ->
                val genderMessage = tailerMessageRepository.findByGenderFor(gender)
                    .joinToString("\n") { it.message }

                clients.map { GreetingDTO(subject, content.format(it.firstName)
                    .plus(genderMessage)) }
            }.flatten()
    }
}