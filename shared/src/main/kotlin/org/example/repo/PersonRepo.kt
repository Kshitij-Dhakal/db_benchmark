package org.example.repo

import org.example.entity.Person

interface PersonRepo {
    fun addPerson(person: Person)

    fun countAllPersons(): Long

    fun deleteAllPersons()
}
