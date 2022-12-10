package org.example.entity.config

import org.example.data_adder.PersonDataAdder
import org.example.data_adder.PersonDataAdderImpl
import org.example.data_adder.PersonDataAdderTimerDecorator
import org.example.generator.RandomNameGenerator
import org.example.repo.PersonRepo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataAdderConfig {
    @Bean
    fun PersonDataAdder(
        personRepo: PersonRepo,
        randomNameGenerator: RandomNameGenerator
    ): PersonDataAdder {
        val personDataAdder = PersonDataAdderImpl(personRepo, randomNameGenerator)
        return PersonDataAdderTimerDecorator(personDataAdder)
    }

    @Bean
    fun randomNameGenerator(): RandomNameGenerator {
        return RandomNameGenerator()
    }
}
