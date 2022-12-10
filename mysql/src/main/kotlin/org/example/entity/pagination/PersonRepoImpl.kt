package org.example.entity.pagination

import org.example.entity.Person
import org.example.repo.PersonRepo
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PersonRepoImpl(private val jdbcTemplate: JdbcTemplate) : PersonRepo {
    override fun addPerson(person: Person) {
        jdbcTemplate
            .execute(
                "INSERT INTO person (id, displayName, createdDate) VALUES(?, ?, ?)"
            ) {
                it.setString(1, person.id.toString())
                it.setString(2, person.displayName)
                it.setLong(3, person.createdDate)
            }
    }

    override fun countAllPersons(): Long {
        return jdbcTemplate
            .queryForObject("SELECT count(*) FROM person p ", Long::class.java) ?: 0
    }

    override fun deleteAllPersons() {
        jdbcTemplate
            .execute("DELETE FROM person")
    }
}
