package org.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("org.example")
class MysqlBenchmarkApplication


fun main(args: Array<String>) {
    runApplication<MysqlBenchmarkApplication>(*args)
}
