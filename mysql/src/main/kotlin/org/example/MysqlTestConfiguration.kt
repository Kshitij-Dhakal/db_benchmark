package org.example

import jakarta.annotation.PostConstruct
import org.example.commons.adder.PersonDataAdder
import org.springframework.stereotype.Service

@Service
class MysqlTestConfiguration(private val personDataAdder: PersonDataAdder) {
    @PostConstruct
    fun addPersonData() {
        personDataAdder.addNPersons(10_000)
    }
}
