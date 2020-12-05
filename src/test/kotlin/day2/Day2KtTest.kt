package day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day2KtTest {

    @Test
    fun calculateRequiredPaper() {
        assertEquals(58, calculateRequiredPaper(Box(2,3,4)))
        assertEquals(43, calculateRequiredPaper(Box(1,1,10)))
    }

    @Test
    fun calculateRequiredRibbon() {
        assertEquals(34, calculateRequiredRibbon(Box(2,3,4)))
        assertEquals(14, calculateRequiredRibbon(Box(1,1,10)))
    }
}