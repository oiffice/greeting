package com.example.greeting.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "client")
data class Client(
    @Id
    val mail: String,
    @Column
    var firstName: String,
    @Column
    var lastName: String,
    @Column
    var gender: String,
    @Column
    var birthday: String // yyyy/M/d
)
