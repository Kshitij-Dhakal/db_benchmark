package org.example.entity

import jakarta.annotation.PostConstruct
import org.example.data_adder.PersonDataAdder
import org.springframework.stereotype.Service

@Service
class TestConfiguration(private val personDataAdder: PersonDataAdder) {
    @PostConstruct
    fun addPersonData() {
        personDataAdder.add1MillionPersons()
    }
}
