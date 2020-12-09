package day5

import java.io.File

val part1Validators = listOf(::threeVowelsValidator, ::twoLettersInRowValidator, ::noStringValidator)
val part2Validators = listOf(::pairOfTwoLettersTwiceValidator, ::repeatingLetterValidator)

fun main() {
    println("Day 5 - Start!")
    val data = loadData("src/main/resources/day5.txt")
    println("Part 1: ${part1(data)}")
    println("Part 2: ${part2(data)}")
}

fun loadData(fileName: String): List<String> {
    return File(fileName).readLines()
}

fun part1(strings: List<String>): Int {
    return findNiceStrings(strings, part1Validators).count()
}

fun findNiceStrings(strings: List<String>, niceValidators: List<(String) -> Boolean>) : List<String> {
    return strings.filter { string -> isNice(string, niceValidators) }
}

fun isNice(string: String, niceValidators: List<(String) -> Boolean>): Boolean {
    for (validator in niceValidators) {
        if (!validator(string)) {
            return false
        }
    }
    return true
}

fun threeVowelsValidator(string: String): Boolean {
    return Regex("[aeiou].*[aeiou].*[aeiou]").containsMatchIn(string)
}

fun twoLettersInRowValidator(string: String): Boolean {
    return Regex("([a-z])\\1").containsMatchIn(string)
}

fun noStringValidator(string: String): Boolean {
    return !Regex("ab|cd|pq|xy").containsMatchIn(string)
}

fun part2(strings: List<String>): Int {
    return findNiceStrings(strings, part2Validators).count()
}

fun pairOfTwoLettersTwiceValidator(string: String): Boolean {
    return Regex("([a-z]{2}).*\\1").containsMatchIn(string)
}

fun repeatingLetterValidator(string: String): Boolean {
    return Regex("(.).\\1").containsMatchIn(string)
}