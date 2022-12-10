package org.example.generator

import java.util.*

class RandomNameGenerator {
    fun getRandomName(seed: Int): String {
        return getRandomName(seed.toLong())
    }

    private fun getRandomName(seed: Long): String {
        val random = Random(seed)
        val firstNames = listOf("John", "Jane", "Adam", "Emma", "Michael", "Sophia", "Mike", "Emily")
        val lastNames = listOf("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia")
        val firstName = firstNames[random.nextInt(firstNames.size)]
        val lastName = lastNames[random.nextInt(lastNames.size)]
        return "$firstName $lastName"
    }
}
