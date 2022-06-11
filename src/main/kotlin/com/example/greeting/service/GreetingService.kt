package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO
import com.example.greeting.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.text.SimpleDateFormat

@Service
class GreetingService {

    @Autowired
    private lateinit var clientRepository: ClientRepository
    @Autowired
    private lateinit var simpleMessageService: SimpleMessageService

    fun greetingBirthday(): List<GreetingDTO> {

        val sdf = SimpleDateFormat("M/d")
        return simpleMessageService.greetingBirthday(clientRepository.findByBirthdayEndsWith(
            sdf.format(Timestamp(System.currentTimeMillis()))
        ).map { ClientDTO(it.mail, it.firstName, it.lastName, it.gender, it.birthday) })

    }
}