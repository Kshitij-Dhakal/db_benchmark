package org.example

import jakarta.annotation.PostConstruct
import org.example.commons.TestConfiguration
import org.example.commons.adder.PersonDataAdder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
class MysqlTestConfiguration(
    private val personDataAdder: PersonDataAdder,
) : TestConfiguration(sampleSize = 1_000_000, stepSize = 10000) {

    @PostConstruct
    fun addPersonData() {
        personDataAdder.addNPersons(sampleSize)
    }

    @Bean(destroyMethod = "shutdown")
    fun getExecutorService(): ExecutorService {
        return Executors.newFixedThreadPool(10)
    }
}
