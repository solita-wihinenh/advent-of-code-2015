package day2

import java.io.File

fun main(args: Array<String>) {
    println("Day 2 - Start!")
    val boxes = loadData("src/main/resources/day2.txt")

    println("Part 1: ${calculateRequiredPaper(boxes)}")

    println("Part 2: ${calculateRequiredRibbon(boxes)}")
}

class Box(l: Int, w: Int, h: Int) {
    val dimensions = listOf(l, w, h).sorted()
    val sides = listOf(l * w, w * h, h * l)

    fun getSmallestSide(): Int {
        return this.sides.minOrNull() ?: throw Error("Invalid box")
    }

    fun getSmallestPerimeter(): Int {
        return this.dimensions[0] * 2 + this.dimensions[1] * 2
    }

    fun getVolume(): Int {
        return this.dimensions.reduce { acc, i -> acc * i }
    }
}

fun loadData(fileName: String): List<Box> {
    val boxes = mutableListOf<Box>()
    File(fileName).forEachLine {
        val dimensions = it.split("x")
        boxes.add(Box(dimensions[0].toInt(), dimensions[1].toInt(), dimensions[2].toInt()))
    }
    return boxes
}

fun calculateRequiredPaper(box: Box): Int {
    return 2 * box.sides[0] + 2 * box.sides[1] + 2 * box.sides[2] + box.getSmallestSide()
}

fun calculateRequiredPaper(boxes: List<Box>): Int {
    return boxes.map { box -> calculateRequiredPaper(box) }.sum()
}

fun calculateRequiredRibbon(box: Box): Int {
    return box.getSmallestPerimeter() + box.getVolume()
}

fun calculateRequiredRibbon(boxes: List<Box>): Int {
    return boxes.map { box -> calculateRequiredRibbon(box) }.sum()
}