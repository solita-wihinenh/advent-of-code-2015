package day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1KtTest {

    @Test
    fun decodeFloor() {
        assertEquals(0, decodeFloor("(())", 0))
        assertEquals(0, decodeFloor("()()", 0))
        assertEquals(3, decodeFloor("(((", 0))
        assertEquals(3, decodeFloor("(()(()(", 0))
        assertEquals(3, decodeFloor("))(((((", 0))
        assertEquals(-1, decodeFloor("())", 0))
        assertEquals(-1, decodeFloor("))(", 0))
        assertEquals(-3, decodeFloor(")))", 0))
        assertEquals(-3, decodeFloor(")())())", 0))
    }
}