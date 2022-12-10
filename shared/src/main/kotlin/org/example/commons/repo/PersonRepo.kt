package org.example.commons.repo

import org.example.commons.entity.Person

interface PersonRepo {
    fun addPerson(person: Person)

    fun countAllPersons(): Long

    fun deleteAllPersons()

    fun getPersonsLimitAndOffset(property: String, order: String, limit: Long, offset: Long): List<Person>

    fun getPersonsRowNumberBetween(property: String, order: String, r1: Long, r2: Long): List<Person>

    fun getPersonsWhereBetween(property: String, order: String, r1: Long, r2: Long): List<Person>
}
