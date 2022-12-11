package org.example

import jakarta.annotation.PostConstruct
import org.example.benchmark.pagination.MysqlRowNumberPaginatedListFetcher
import org.example.benchmark.pagination.MysqlWherePaginatedListFetcher
import org.example.benchmark.pagination.PaginatedListFetcher
import org.example.benchmark.pagination.PaginationBenchmarkTimer
import org.example.commons.TestConfiguration
import org.example.commons.entity.Person
import org.example.commons.generator.ReportGenerator
import org.example.pagination.MysqlOffsetPaginatedListFetcher
import org.springframework.stereotype.Service

@Service
class MysqlTestRunner(
    private val f3: MysqlWherePaginatedListFetcher,
    private val f1: MysqlOffsetPaginatedListFetcher,
    private val testConfiguration: TestConfiguration,
    private val f2: MysqlRowNumberPaginatedListFetcher
) {
    @PostConstruct
    fun runBenchmark() = run {
        val data = mutableMapOf<String, List<Long>>()
        data["mysql offset"] = internalRunBenchmark(f1)
        data["mysql row_number"] = internalRunBenchmark(f2)
        data["mysql where"] = internalRunBenchmark(f3)
        ReportGenerator(testConfiguration).generateReport(data, "pagination_report.csv")
    }

    private fun internalRunBenchmark(
        paginatedListFetcher: PaginatedListFetcher<Person>
    ): List<Long> {
        println("Running benchmark for ${paginatedListFetcher.javaClass}")
        return PaginationBenchmarkTimer(paginatedListFetcher, testConfiguration).runBenchmark()
    }
}
