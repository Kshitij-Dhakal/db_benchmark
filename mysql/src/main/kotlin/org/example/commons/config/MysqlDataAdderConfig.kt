package org.example.commons.config

import org.example.commons.adder.PersonDataAdder
import org.example.commons.adder.PersonDataAdderImpl
import org.example.commons.adder.PersonDataAdderTimer
import org.example.commons.generator.RandomNameGenerator
import org.example.commons.repo.PersonRepo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MysqlDataAdderConfig {
    @Bean
    fun PersonDataAdder(
        personRepo: PersonRepo,
        randomNameGenerator: RandomNameGenerator
    ): PersonDataAdder {
        val personDataAdder = PersonDataAdderImpl(personRepo, randomNameGenerator)
        return PersonDataAdderTimer(personDataAdder)
    }

    @Bean
    fun randomNameGenerator(): RandomNameGenerator {
        return RandomNameGenerator()
    }
}
