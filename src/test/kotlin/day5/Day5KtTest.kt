package day5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day5KtTest {

    @Test
    fun isNice() {
        assertEquals(true, isNice("ugknbfddgicrmopn", part1Validators))
        assertEquals(true, isNice("aaa", part1Validators))
        assertEquals(false, isNice("jchzalrnumimnmhp", part1Validators))
        assertEquals(false, isNice("haegwjzuvuyypxyu", part1Validators))
        assertEquals(false, isNice("dvszwmarrgswjxmb", part1Validators))

        assertEquals(true, isNice("xyxy", listOf(::pairOfTwoLettersTwiceValidator)))
        assertEquals(true, isNice("aabcdefgaa", listOf(::pairOfTwoLettersTwiceValidator)))
        assertEquals(false, isNice("aaa", listOf(::pairOfTwoLettersTwiceValidator)))
        assertEquals(true, isNice("xyx", listOf(::repeatingLetterValidator)))
        assertEquals(true, isNice("abcdefeghi", listOf(::repeatingLetterValidator)))
        assertEquals(true, isNice("aaa", listOf(::repeatingLetterValidator)))

        assertEquals(true, isNice("qjhvhtzxzqqjkmpb", part2Validators))
        assertEquals(true, isNice("xxyxx", part2Validators))
        assertEquals(false, isNice("uurcxstgmygtbstg", part2Validators))
        assertEquals(false, isNice("ieodomkazucvgmuy", part2Validators))
    }
}