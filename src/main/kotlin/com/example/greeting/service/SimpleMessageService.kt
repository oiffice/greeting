package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

@Service("simple")
class SimpleMessageService: MessageService {

    private val subject = "Subject: Happy birthday!\n"
    private val content = "Happy birthday, dear %s!\n"
    private val elderAge = 49
    private val elderFilePath = "<file_path>"

    override fun greetingBirthday(clients: List<ClientDTO>): List<GreetingDTO> {
        val sdf = SimpleDateFormat("yyyy/M/d")
        val (elder, youth) = clients.partition { client ->
            val birthdayCal = Calendar.getInstance().also { it.time = sdf.parse(client.birthday)  }
            val currentCal = Calendar.getInstance().also { it.time = Timestamp(System.currentTimeMillis()) }
            currentCal.get(Calendar.YEAR).minus(birthdayCal.get(Calendar.YEAR)) >= 49
        }

        val greetings = elder.map { GreetingDTO(subject, content.format(it.firstName), elderFilePath) }.toMutableList()
        greetings.addAll(youth.map { GreetingDTO(subject, content.format(it.firstName)) })
        return greetings
    }
}