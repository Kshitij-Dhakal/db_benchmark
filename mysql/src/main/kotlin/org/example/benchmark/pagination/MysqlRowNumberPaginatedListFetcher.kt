package org.example.benchmark.pagination

import org.example.commons.entity.Person
import org.example.commons.repo.PersonRepo
import org.springframework.stereotype.Repository

@Repository
class MysqlRowNumberPaginatedListFetcher(private val personRepo: PersonRepo) : PaginatedListFetcher<Person> {
    override fun fetchNext(token: Long): List<Person> {
        return personRepo.getPersonsRowNumberBetween("createdDate", "ASC", token, token + 99)
    }
}
