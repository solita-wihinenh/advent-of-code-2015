package day4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day4KtTest {

    @Test
    fun bruteForcePrefix() {
        assertEquals("609043", bruteForcePrefix("abcdef", "00000"))
        assertEquals("1048970", bruteForcePrefix("abcdef", "000000"))
    }
}