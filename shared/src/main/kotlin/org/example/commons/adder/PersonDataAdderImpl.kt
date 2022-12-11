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
    override fun addNPersons(n: Number) {
        println("Populating person table")
        val count = personRepo.countAllPersons()
        if (count == n) {
            println("Data already exists")
            return
        }
        println("$count records exists! Deleting existing records.")
        personRepo.deleteAllPersons()
        println("Adding persons")
        // using a for loop
        val records = mutableListOf<Person>()
        for (i in 1..n.toLong()) {
            // do something
            val person = Person(UUID.randomUUID(), randomNameGenerator.getRandomName(), i)
            records.add(person)
        }
        personRepo.addAll(records)
        println("${n.toLong()} persons added")
    }
}
