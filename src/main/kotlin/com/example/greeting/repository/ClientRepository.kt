package com.example.greeting.repository

import com.example.greeting.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<Client, String> {

    fun findByBirthdayEndsWith(birthday: String): List<Client>
}