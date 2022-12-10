package org.example.pagination

import org.example.benchmark.pagination.PaginatedListFetcher
import org.example.commons.entity.Person
import org.example.commons.repo.PersonRepo
import org.springframework.stereotype.Repository

@Repository
class MysqlOffsetPaginatedListFetcher(private val personRepo: PersonRepo) : PaginatedListFetcher<Person> {

    override fun fetchNext(token: Long): List<Person> {
        return personRepo.getPersonsLimitAndOffset("createdDate", "ASC", 100, token)
    }
}
