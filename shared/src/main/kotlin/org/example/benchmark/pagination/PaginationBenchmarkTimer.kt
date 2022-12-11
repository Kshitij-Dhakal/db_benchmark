package org.example.benchmark.pagination

import org.example.commons.TestConfiguration
import kotlin.system.measureTimeMillis

class PaginationBenchmarkTimer<T>(
    private val paginatedListFetcher: PaginatedListFetcher<T>,
    private val testConfiguration: TestConfiguration
) :
    PaginationBenchmark {
    override fun runBenchmark(): List<Long> {
        println("Running pagination benchmark")
        // measure the running time of this function
        val numbers = mutableListOf<Long>()
        val elapsedTime = measureTimeMillis {
            // do something here
            for (i in 1..testConfiguration.sampleSize.toLong() step testConfiguration.stepSize.toLong()) {
                numbers.add(fetchNext(i))
            }
        }
        println("Elapsed time: $elapsedTime ms")
        return numbers
    }

    private fun fetchNext(i: Long): Long {
        return measureTimeMillis {
            paginatedListFetcher.fetchNext(i)
        }
    }
}
