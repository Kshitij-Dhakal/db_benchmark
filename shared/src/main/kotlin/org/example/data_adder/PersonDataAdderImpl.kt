package org.example.data_adder

import org.example.entity.Person
import org.example.generator.RandomNameGenerator
import org.example.repo.PersonRepo
import java.util.*

private const val PERSON_SAMPLE_SIZE = 1_000_000L

open class PersonDataAdderImpl(
    private val personRepo: PersonRepo,
    private val randomNameGenerator: RandomNameGenerator
) :
    PersonDataAdder {
    override fun add1MillionPersons() {
        println("Populating person table")
        val count = personRepo.countAllPersons()
        if (count >= PERSON_SAMPLE_SIZE) {
            println("Data already exists")
            return
        }
        println("Deleting existing data")
        personRepo.deleteAllPersons()
        println("Adding persons")
        // using a for loop
        for (i in 1..PERSON_SAMPLE_SIZE) {
            // do something
            val person = Person(UUID.randomUUID(), randomNameGenerator.getRandomName(i), i)
            personRepo.addPerson(person)
        }
        println("1M persons added")
    }
}
