package org.example

import jakarta.annotation.PostConstruct
import org.example.benchmark.pagination.MysqlRowNumberPaginatedListFetcher
import org.example.benchmark.pagination.MysqlWherePaginatedListFetcher
import org.example.benchmark.pagination.PaginationBenchmarkTimer
import org.example.commons.TestConfiguration
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
    fun runBenchmark() {
        val data = mutableMapOf<String, List<Long>>()
        data["mysql offset"] = PaginationBenchmarkTimer(f1, testConfiguration).runBenchmark()
        data["mysql row_number"] = PaginationBenchmarkTimer(f2, testConfiguration).runBenchmark()
        data["mysql where"] = PaginationBenchmarkTimer(f3, testConfiguration).runBenchmark()
        ReportGenerator().generateReport(data, "pagination_report.csv")
    }
}
