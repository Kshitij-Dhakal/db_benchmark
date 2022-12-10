package org.example.benchmark.pagination

import kotlin.system.measureTimeMillis

class PaginationBenchmarkTimer<T>(private val paginatedListFetcher: PaginatedListFetcher<T>) :
    PaginationBenchmark {
    override fun runBenchmark() {
        println("Running pagination benchmark")
        // measure the running time of this function
        val elapsedTime = measureTimeMillis {
            // do something here
            for (i in 1..10_000 step 100) {
                fetchNext(i.toLong())
            }
        }
        println("Elapsed time: $elapsedTime ms")
    }

    private fun fetchNext(i: Long): Long {
        return measureTimeMillis {
            paginatedListFetcher.fetchNext(i)
        }
    }
}
