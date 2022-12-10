package org.example.commons.repo

import org.example.commons.entity.Person
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.*

class PersonRowMapper : RowMapper<Person> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Person {
        val id = rs.getString("id")
        val displayName = rs.getString("displayName")
        val createdDate = rs.getLong("createdDate")
        return Person(UUID.fromString(id), displayName, createdDate)
    }
}
