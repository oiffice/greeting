package com.example.greeting.service

import com.example.greeting.config.FactoryConfig
import com.example.greeting.enums.GreetingTypEnum
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [MessageServiceFactory::class, FactoryConfig::class,
SimpleMessageService::class, TailerMessageService::class])
class MessageFactoryTest {

    @Autowired
    private lateinit var messageServiceFactory: MessageServiceFactory

    @Test
    fun `should be a simpleMessageService`() {
        assert(messageServiceFactory.getMessageService(GreetingTypEnum.SIMPLE.type) is SimpleMessageService)
    }

    @Test
    fun `should be a tailerMessageService`() {
        assert(messageServiceFactory.getMessageService(GreetingTypEnum.TAILER.type) is TailerMessageService)
    }
}