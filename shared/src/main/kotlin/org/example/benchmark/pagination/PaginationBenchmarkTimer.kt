package org.example.benchmark.pagination

import kotlin.system.measureTimeMillis

class PaginationBenchmarkTimer<T>(private val paginatedListFetcher: PaginatedListFetcher<T>) :
    PaginationBenchmark {
    override fun runBenchmark(): List<Long> {
        println("Running pagination benchmark")
        // measure the running time of this function
        val numbers = mutableListOf<Long>()
        val elapsedTime = measureTimeMillis {
            // do something here
            for (i in 1..50_000 step 500) {
                numbers.add(fetchNext(i.toLong()))
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
