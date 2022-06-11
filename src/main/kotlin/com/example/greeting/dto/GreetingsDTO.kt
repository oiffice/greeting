package com.example.greeting.dto

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "Greetings")
data class GreetingsDTO(
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Greeting")
    val greetingDTOs: List<GreetingDTO>
)
