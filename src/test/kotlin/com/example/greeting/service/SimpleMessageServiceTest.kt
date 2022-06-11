package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.service.SimpleMessageService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SimpleMessageService::class])
class SimpleMessageServiceTest {

    @Autowired
    private lateinit var simpleMessageService: SimpleMessageService

    @Test
    fun `simple message for male`() {
        val greetings = simpleMessageService.greetingBirthday(listOf(ClientDTO("mail", "first",
            "last", "male", "1988/4/7")))

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\n", greetings[0].content)
    }

    @Test
    fun `simple message for female`() {
        val greetings = simpleMessageService.greetingBirthday(listOf(ClientDTO("mail", "first",
            "last", "female", "1988/4/7")))

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\n", greetings[0].content)
    }
}