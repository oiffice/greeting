package com.example.greeting.controller

import com.example.greeting.GreetingApplication
import com.example.greeting.GreetingController
import com.example.greeting.dto.GreetingDTO
import com.example.greeting.enums.GreetingTypEnum
import com.example.greeting.service.GreetingService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@ContextConfiguration(classes = [GreetingApplication::class])
@AutoConfigureMockMvc(addFilters = false)
class GreetingControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc
    @MockBean
    private lateinit var greetingService: GreetingService

    @Test
    fun `simple message`() {
        `when`(greetingService.greetingBirthday(GreetingTypEnum.SIMPLE.type))
            .thenReturn(listOf(GreetingDTO("subject", "content")))
        mockMvc.perform(get("/api/greeting/birthday")
            .param("type", GreetingTypEnum.SIMPLE.type)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[0].subject").isNotEmpty)
            .andExpect(jsonPath("$.[0].content").isNotEmpty)
    }
    @Test
    fun `tailer message`() {
        `when`(greetingService.greetingBirthday(GreetingTypEnum.TAILER.type))
            .thenReturn(listOf(GreetingDTO("subject", "content\nWe offer")))
        val result = mockMvc.perform(get("/api/greeting/birthday")
            .param("type", GreetingTypEnum.TAILER.type)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[0].subject").isNotEmpty)
            .andExpect(jsonPath("$.[0].content").isNotEmpty)
            .andReturn()

        assert(result.response.contentAsString.contains("We offer"))
    }
}