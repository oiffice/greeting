package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.dto.GreetingDTO
import com.example.greeting.entity.Client
import com.example.greeting.enums.GreetingTypEnum
import com.example.greeting.repository.ClientRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [GreetingService::class, MessageServiceFactory::class])
class GreetingServiceTest: Common() {

    @Autowired
    private lateinit var greetingService: GreetingService
    @MockBean
    private lateinit var messageServiceFactory: MessageServiceFactory
    @MockBean
    private lateinit var simpleMessageService: SimpleMessageService
    @MockBean
    private lateinit var clientRepository: ClientRepository

    @Test
    fun `simple message for male`() {
        `when`(clientRepository.findByBirthdayEndsWith(anyString()))
            .thenReturn(listOf(Client("mail", "first", "last", "male", "1988/4/7")))
        `when`(messageServiceFactory.getMessageService(safeEq(GreetingTypEnum.SIMPLE.type)))
            .thenReturn(simpleMessageService)
        `when`(simpleMessageService.greetingBirthday(anyList<ClientDTO>()))
            .thenReturn(listOf(GreetingDTO("Subject: Happy birthday!\n",
                "Happy birthday, dear first!\n")))

        val greetings = greetingService.greetingBirthday(GreetingTypEnum.SIMPLE.type)

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\n", greetings[0].content)
    }

    @Test
    fun `simple message for female`() {
        `when`(clientRepository.findByBirthdayEndsWith(anyString()))
            .thenReturn(listOf(Client("mail", "first", "last", "male", "1988/4/7")))
        `when`(messageServiceFactory.getMessageService(safeEq(GreetingTypEnum.SIMPLE.type)))
            .thenReturn(simpleMessageService)
        `when`(simpleMessageService.greetingBirthday(anyList<ClientDTO>()))
            .thenReturn(listOf(GreetingDTO("Subject: Happy birthday!\n",
                "Happy birthday, dear first!\n")))

        val greetings = greetingService.greetingBirthday(GreetingTypEnum.SIMPLE.type)

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\n", greetings[0].content)

    }

    @Test
    fun `tailer message for male`() {
        `when`(clientRepository.findByBirthdayEndsWith(anyString()))
            .thenReturn(listOf(Client("mail", "first", "last", "male", "1988/4/7")))
        `when`(messageServiceFactory.getMessageService(safeEq(GreetingTypEnum.TAILER.type)))
            .thenReturn(simpleMessageService)
        `when`(simpleMessageService.greetingBirthday(anyList<ClientDTO>()))
            .thenReturn(listOf(GreetingDTO("Subject: Happy birthday!\n",
                "Happy birthday, dear first!\n" +
                        "We offer special discount 20% off for the following items:\n" +
                        "White Wine, iPhone X\n")))

        val greetings = greetingService.greetingBirthday(GreetingTypEnum.TAILER.type)

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\nWe offer special discount 20% off for the following items:\n" +
                "White Wine, iPhone X\n", greetings[0].content)
    }

    @Test
    fun `tailer message for female`() {
        `when`(clientRepository.findByBirthdayEndsWith(anyString()))
            .thenReturn(listOf(Client("mail", "first", "last", "male", "1988/4/7")))
        `when`(messageServiceFactory.getMessageService(safeEq(GreetingTypEnum.TAILER.type)))
            .thenReturn(simpleMessageService)
        `when`(simpleMessageService.greetingBirthday(anyList<ClientDTO>()))
            .thenReturn(listOf(GreetingDTO("Subject: Happy birthday!\n",
                "Happy birthday, dear first!\n" +
                        "We offer special discount 50% off for the following items:\n" +
                        "Cosmetic, LV Handbags\n")))

        val greetings = greetingService.greetingBirthday(GreetingTypEnum.TAILER.type)

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\nWe offer special discount 50% off for the following items:\n" +
                "Cosmetic, LV Handbags\n", greetings[0].content)

    }
}