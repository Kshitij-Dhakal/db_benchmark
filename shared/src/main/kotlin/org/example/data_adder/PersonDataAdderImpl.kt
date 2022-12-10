package org.example.data_adder

import org.example.entity.Person
import org.example.generator.RandomNameGenerator
import org.example.repo.PersonRepo
import java.util.*

open class PersonDataAdderImpl(
    private val personRepo: PersonRepo,
    private val randomNameGenerator: RandomNameGenerator
) :
    PersonDataAdder {
    override fun add1MillionPersons() {
        println("Populating person table")
        val count = personRepo.countAllPersons()
        if (count >= 1000000) {
            println("Data already exists")
            return
        }
        println("Deleting existing data")
        personRepo.deleteAllPersons()
        println("Adding persons")
        var createdDate = System.currentTimeMillis()
        // using a for loop
        for (i in 1..1_000_000) {
            // do something
            val person = Person(UUID.randomUUID(), randomNameGenerator.getRandomName(i), createdDate++)
            personRepo.addPerson(person)
        }
        println("1M persons added")
    }
}
