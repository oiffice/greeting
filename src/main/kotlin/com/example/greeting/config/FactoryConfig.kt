package com.example.greeting.config

import com.example.greeting.service.MessageServiceFactory
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FactoryConfig {

    @Bean
    fun messageFactory(): FactoryBean<*> {
        val factory = ServiceLocatorFactoryBean()
        factory.setServiceLocatorInterface(MessageServiceFactory::class.java)
        return factory
    }
}