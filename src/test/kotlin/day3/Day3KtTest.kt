package day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day3KtTest {

    @Test
    fun part1() {
        assertEquals(2, part1(">"))
        assertEquals(4, part1("^>v<"))
        assertEquals(2, part1("^v^v^v^v^v"))
    }

    @Test
    fun part2() {
        assertEquals(3, part2("^v"))
        assertEquals(3, part2("^>v<"))
        assertEquals(11, part2("^v^v^v^v^v"))
    }
}