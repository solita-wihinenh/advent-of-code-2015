package day3

import java.awt.Point
import java.io.File

fun main() {
    println("Day 3 - Start!")
    val instructions = loadData("src/main/resources/day3.txt")

    println("Part 1: ${part1(instructions)}")

    println("Part 2: ${part2(instructions)}")
}

class Santa(pos: Point) {
    var x = pos.x;
    var y = pos.y;

    val visitedHouses = mutableMapOf<Point, Int>(Pair(Point(x, y), 1))

    fun followInstruction(instruction: Char) {
        when (instruction) {
            '>' -> x++
            '<' -> x--
            '^' -> y++
            'v' -> y--
        }
        visitedHouses[Point(x, y)] = (visitedHouses[Point(x, y)] ?: 0) + 1
    }
}

fun loadData(fileName: String): String {
    return File(fileName).readText()
}

fun part1(instructions: String): Int {
    val santa = Santa(Point(0, 0))
    for (instruction in instructions) {
        santa.followInstruction(instruction)
    }
    return santa.visitedHouses.count()
}

fun part2(instructions: String): Int {
    val santa = Santa(Point(0, 0))
    val roboSanta = Santa(Point(0, 0))
    var santasTurn = true;
    for (instruction in instructions) {
        if (santasTurn) {
            santa.followInstruction(instruction)
        } else {
            roboSanta.followInstruction(instruction)
        }
        santasTurn = !santasTurn
    }
    val allVisitedHouses = santa.visitedHouses + roboSanta.visitedHouses
    return allVisitedHouses.count()
}