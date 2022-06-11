package com.example.greeting.repository

import com.example.greeting.entity.TailerMessage
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TailerMessageRepository: JpaRepository<TailerMessage, UUID> {

    fun findByGenderFor(gender: String): List<TailerMessage>
}