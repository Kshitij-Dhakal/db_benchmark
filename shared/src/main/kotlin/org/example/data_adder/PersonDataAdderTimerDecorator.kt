package org.example.data_adder

import kotlin.system.measureTimeMillis

class PersonDataAdderTimerDecorator(private val personDataAdder: PersonDataAdderImpl): PersonDataAdder {
    override fun add1MillionPersons() {
        // measure the running time of this function
        val elapsedTime = measureTimeMillis {
            // do something here
            personDataAdder.add1MillionPersons()
        }
        println("Elapsed time: $elapsedTime ms")
    }
}
