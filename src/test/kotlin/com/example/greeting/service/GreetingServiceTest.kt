package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO
import com.example.greeting.entity.Client
import com.example.greeting.repository.ClientRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [GreetingService::class, SimpleMessageService::class])
class GreetingServiceTest {

    @Autowired
    private lateinit var greetingService: GreetingService
    @MockBean
    private lateinit var simpleMessageService: SimpleMessageService
    @MockBean
    private lateinit var clientRepository: ClientRepository

    @Test
    fun `simple message for male`() {
        `when`(clientRepository.findByBirthdayEndsWith(anyString()))
            .thenReturn(listOf(Client("mail", "first", "last", "male", "1988/4/7")))
        `when`(simpleMessageService.greetingBirthday(anyList<ClientDTO>()))
            .thenReturn(listOf(GreetingDTO("Subject: Happy birthday!\n",
                "Happy birthday, dear first!\n")))

        val greetings = greetingService.greetingBirthday()

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\n", greetings[0].content)
    }

    @Test
    fun `simple message for female`() {
        `when`(clientRepository.findByBirthdayEndsWith(anyString()))
            .thenReturn(listOf(Client("mail", "first", "last", "male", "1988/4/7")))
        `when`(simpleMessageService.greetingBirthday(anyList<ClientDTO>()))
            .thenReturn(listOf(GreetingDTO("Subject: Happy birthday!\n",
                "Happy birthday, dear first!\n")))

        val greetings = greetingService.greetingBirthday()

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\n", greetings[0].content)

    }
}