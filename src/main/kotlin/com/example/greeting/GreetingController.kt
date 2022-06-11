package com.example.greeting

import com.example.greeting.dto.GreetingDTO
import com.example.greeting.dto.GreetingsDTO
import com.example.greeting.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/greeting")
class GreetingController {

    @Autowired
    private lateinit var greetingService: GreetingService

    @RequestMapping("/birthday", method = [RequestMethod.GET], produces = [MediaType.APPLICATION_XML_VALUE])
    fun greetingBirthday(@RequestParam("type") type: String): GreetingsDTO {
        return greetingService.greetingBirthday(type)
    }
}