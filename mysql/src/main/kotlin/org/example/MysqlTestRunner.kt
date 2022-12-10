package org.example

import jakarta.annotation.PostConstruct
import org.example.benchmark.pagination.MysqlRowNumberPaginatedListFetcher
import org.example.benchmark.pagination.MysqlWherePaginatedListFetcher
import org.example.benchmark.pagination.PaginationBenchmarkTimer
import org.example.commons.generator.ReportGenerator
import org.example.pagination.MysqlOffsetPaginatedListFetcher
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Service

@Service
@DependsOn("mysqlTestConfiguration")
class MysqlTestRunner(
    private val f1: MysqlOffsetPaginatedListFetcher,
    private val f2: MysqlRowNumberPaginatedListFetcher,
    private val f3: MysqlWherePaginatedListFetcher
) {
    @PostConstruct
    fun runBenchmark() {
        val data = mutableMapOf<String, List<Long>>()
        data.put("mysql-offset", PaginationBenchmarkTimer(f1).runBenchmark())
        data.put("mysql-row_number", PaginationBenchmarkTimer(f2).runBenchmark())
        data.put("mysql-where", PaginationBenchmarkTimer(f3).runBenchmark())
        ReportGenerator().generateReport(data, "pagination_report.csv")
    }
}
