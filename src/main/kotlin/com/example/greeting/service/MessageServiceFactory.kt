package com.example.greeting.service

interface MessageServiceFactory {
    fun getMessageService(type: String): MessageService
}