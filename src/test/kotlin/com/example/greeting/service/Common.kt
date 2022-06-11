package com.example.greeting.service

import org.mockito.Mockito

open class Common {

    fun <T: Any> safeEq(value: T): T = Mockito.eq(value) ?: value
}