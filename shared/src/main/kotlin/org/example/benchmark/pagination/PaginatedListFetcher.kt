package org.example.benchmark.pagination

interface PaginatedListFetcher<T> {
    fun fetchNext(token: Long): List<T>
}
