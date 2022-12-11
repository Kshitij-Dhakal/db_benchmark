package org.example.pagination

import org.example.benchmark.pagination.PaginatedListFetcher
import org.example.commons.TestConfiguration
import org.example.commons.entity.Person
import org.example.commons.repo.PersonRepo
import org.springframework.stereotype.Repository

@Repository
class MysqlOffsetPaginatedListFetcher(
    private val personRepo: PersonRepo,
    private val testConfiguration: TestConfiguration
) : PaginatedListFetcher<Person> {

    override fun fetchNext(token: Long): List<Person> {
        return personRepo.getPersonsLimitAndOffset("createdDate", "ASC", testConfiguration.stepSize.toLong(), token)
    }
}
