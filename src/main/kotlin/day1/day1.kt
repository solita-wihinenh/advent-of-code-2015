package day1

import java.io.File

fun main(args: Array<String>) {
    println("Day 1 - Start!")
    val instructions = loadData("src/main/resources/day1.txt")
    println("Part 1: ${decodeFloor(instructions, 0)}")
    println("Part 2: ${decodeFloor(instructions, 0, -1)}")
}

fun loadData(fileName: String): String {
    return File(fileName).readText()
}

fun decodeFloor(instructions: String, startingFloor: Int, targetFloor: Int? = null): Int {
    var floor = startingFloor;
    for (i in instructions.indices) {
        when (instructions[i]) {
            '(' -> {
                floor++;
            }
            ')' -> {
                floor--;
            }
            else -> {
                throw Error("Cannot decode char ${instructions[i]}")
            }
        }
        if (targetFloor != null && targetFloor == floor) {
            return i + 1
        }
    }
    return floor
}