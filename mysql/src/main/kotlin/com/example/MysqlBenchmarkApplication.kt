package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MysqlBenchmarkApplication

fun main(args: Array<String>) {
    runApplication<MysqlBenchmarkApplication>(*args)
}
