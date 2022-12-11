package org.example.commons.adder

import kotlin.system.measureTimeMillis

class PersonDataAdderTimer(private val personDataAdder: PersonDataAdderImpl) : PersonDataAdder {
    override fun addNPersons(n: Number) {
        // measure the running time of this function
        val elapsedTime = measureTimeMillis {
            // do something here
            personDataAdder.addNPersons(n)
        }
        println("Elapsed time: $elapsedTime ms")
    }
}
