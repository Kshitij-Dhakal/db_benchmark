package org.example

import jakarta.annotation.PostConstruct
import org.example.commons.TestConfiguration
import org.example.commons.adder.PersonDataAdder
import org.springframework.stereotype.Service

@Service
class MysqlTestConfiguration(
    private val personDataAdder: PersonDataAdder,
) : TestConfiguration(sampleSize = 1_00_000, stepSize = 1000) {

    @PostConstruct
    fun addPersonData() {
        personDataAdder.addNPersons(sampleSize)
    }
}
