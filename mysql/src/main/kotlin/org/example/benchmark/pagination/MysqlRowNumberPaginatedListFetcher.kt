package org.example.benchmark.pagination

import org.example.commons.TestConfiguration
import org.example.commons.entity.Person
import org.example.commons.repo.PersonRepo
import org.springframework.stereotype.Repository

@Repository
class MysqlRowNumberPaginatedListFetcher(
    private val personRepo: PersonRepo,
    private val testConfiguration: TestConfiguration
) : PaginatedListFetcher<Person> {
    override fun fetchNext(token: Long): List<Person> {
        return personRepo.getPersonsRowNumberBetween(
            "createdDate",
            "ASC",
            token,
            token + testConfiguration.stepSize.toLong() - 1
        )
    }
}
