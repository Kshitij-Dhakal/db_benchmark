package org.example.commons.generator

import org.example.commons.TestConfiguration
import java.io.File
import java.util.*

class ReportGenerator(private val testConfiguration: TestConfiguration) {
    fun generateReport(data: Map<String, List<Long>>, filePath: String) {
        //=ADD(MULTIPLY(MINUS(ROW(),2),1000),1)
        val sortedData: SortedMap<String, List<Long>> = if (data is SortedMap) {
            data
        } else {
            data.toSortedMap()
        }
        val csvBodyRows = mutableListOf("row, ${sortedData.keys.joinToString(", ")}")
        val numList = data.entries.first().value

        for (i in 1..numList.size) {
            val rowNumb = mutableListOf<Long>()
            for (key in sortedData.keys) {
                rowNumb.add(sortedData[key]!![i - 1])
            }
            csvBodyRows.add("${i * testConfiguration.stepSize.toLong()}, ${rowNumb.joinToString(", ")}")
        }

        val file = File(filePath)
        file.writeText(csvBodyRows.joinToString("\n"))
        println("Report generated on ${file.absoluteFile}")
    }

}
