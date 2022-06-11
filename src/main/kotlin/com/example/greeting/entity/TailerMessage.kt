package com.example.greeting.entity

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tailer_message")
data class TailerMessage(
    @Id
    val messageId: UUID,
    @Column
    val tailerId: UUID,
    @Column
    var message: String,
    @Column
    var genderFor: String
)
