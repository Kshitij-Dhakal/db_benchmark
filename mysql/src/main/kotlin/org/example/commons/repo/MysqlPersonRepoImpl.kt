package org.example.commons.repo

import org.example.commons.entity.Person
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MysqlPersonRepoImpl(private val jdbcTemplate: JdbcTemplate) : PersonRepo {
    override fun addPerson(person: Person) {
        jdbcTemplate
            .update(
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

    override fun getPersonsLimitAndOffset(property: String, order: String, limit: Long, offset: Long): List<Person> {
        val query = "SELECT * FROM person ORDER BY $property $order LIMIT ?, ?"
        return jdbcTemplate
            .query(query, PersonRowMapper(), offset, limit)
    }

    override fun getPersonsRowNumberBetween(property: String, order: String, r1: Long, r2: Long): List<Person> {
        val query = """SELECT *
                FROM (
                    SELECT *, ROW_NUMBER() OVER (ORDER BY $property $order) AS rn
                    FROM person
                ) AS t
                WHERE rn BETWEEN ? AND ?
                """.trimIndent()
        return jdbcTemplate
            .query(query, PersonRowMapper(), r1, r2)
    }

    override fun getPersonsWhereBetween(property: String, order: String, r1: Long, r2: Long): List<Person> {
        val query = "SELECT * FROM person WHERE createdDate BETWEEN ? AND ? ORDER BY $property $order"
        return jdbcTemplate
            .query(query, PersonRowMapper(), r1, r2)
    }
}
