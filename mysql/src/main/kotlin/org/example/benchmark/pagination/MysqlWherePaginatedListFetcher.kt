package org.example.benchmark.pagination

import org.example.commons.entity.Person
import org.example.commons.repo.PersonRepo
import org.springframework.stereotype.Repository

@Repository
class MysqlWherePaginatedListFetcher(private val personRepo: PersonRepo) : PaginatedListFetcher<Person> {
    override fun fetchNext(token: Long): List<Person> {
        return personRepo.getPersonsWhereBetween("createdDate", "ASC", token, token + 99)
    }
}
