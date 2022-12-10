package org.example

import jakarta.annotation.PostConstruct
import org.example.benchmark.pagination.MysqlWherePaginatedListFetcher
import org.example.benchmark.pagination.PaginationBenchmarkTimer
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Service

@Service
@DependsOn("mysqlTestConfiguration")
class MysqlTestRunner(private val paginationBenchmark: MysqlWherePaginatedListFetcher) {
    @PostConstruct
    fun runBenchmark() {
        PaginationBenchmarkTimer(paginationBenchmark).runBenchmark()
    }
}
