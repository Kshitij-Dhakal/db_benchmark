package org.example.commons.adder

import org.example.commons.entity.Person
import org.example.commons.generator.RandomNameGenerator
import org.example.commons.repo.PersonRepo
import java.util.*

open class PersonDataAdderImpl(
    private val personRepo: PersonRepo,
    private val randomNameGenerator: RandomNameGenerator
) :
    PersonDataAdder {
    override fun addNPersons(n: Long) {
        println("Populating person table")
        val count = personRepo.countAllPersons()
        if (count == n) {
            println("Data already exists")
            return
        }
        println("Deleting existing data")
        personRepo.deleteAllPersons()
        println("Adding persons")
        // using a for loop
        for (i in 1..n) {
            // do something
            val person = Person(UUID.randomUUID(), randomNameGenerator.getRandomName(i), i)
            personRepo.addPerson(person)
        }
        println("1M persons added")
    }
}
