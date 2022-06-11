package com.example.greeting.service

import com.example.greeting.dto.ClientDTO
import com.example.greeting.entity.TailerMessage
import com.example.greeting.repository.TailerMessageRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import java.util.*

@SpringBootTest
@ContextConfiguration(classes = [TailerMessageService::class, TailerMessageRepository::class])
class TailerMessageTest: Common() {

    @Autowired
    private lateinit var tailerMessageService: TailerMessageService
    @MockBean
    private lateinit var tailerMessageRepository: TailerMessageRepository

    @Test
    fun `tailer message for male`() {
        `when`(tailerMessageRepository.findByGenderFor(safeEq("male")))
            .thenReturn(listOf(TailerMessage(UUID.randomUUID(), UUID.randomUUID(), "We offer special discount 20% off for the following items:\n" +
                    "White Wine, iPhone X\n", "male")))
        val greetings = tailerMessageService.greetingBirthday(listOf(ClientDTO("mail", "first",
            "last", "male", "1988/4/7")))

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\nWe offer special discount 20% off for the following items:\n" +
                "White Wine, iPhone X\n", greetings[0].content)
    }

    @Test
    fun `tailer message for female`() {
        `when`(tailerMessageRepository.findByGenderFor(safeEq("female")))
            .thenReturn(listOf(TailerMessage(UUID.randomUUID(), UUID.randomUUID(), "We offer special discount 50% off for the following items:\n" +
                    "Cosmetic, LV Handbags\n", "female")))
        val greetings = tailerMessageService.greetingBirthday(listOf(ClientDTO("mail", "first",
            "last", "female", "1988/4/7")))

        assertEquals("Subject: Happy birthday!\n", greetings[0].subject)
        assertEquals("Happy birthday, dear first!\nWe offer special discount 50% off for the following items:\n" +
                "Cosmetic, LV Handbags\n", greetings[0].content)
    }
}