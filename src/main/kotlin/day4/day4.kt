package day4

import java.security.MessageDigest


fun main(args: Array<String>) {
    println("Day 4 - Start!")

    println("Part 1: ${bruteForcePrefix("iwrupvqb", "00000")}")

    //println("Part 2: ${bruteForcePrefix("iwrupvqb", "000000")}")
}

fun generateMD5(input: String): ByteArray {
    val byteString = input.toByteArray()
    val md = MessageDigest.getInstance("MD5")
    return md.digest(byteString);
}

fun ByteArray.toHexString() = joinToString("") {
    "%02x".format(it)
}

fun bruteForcePrefix(secret: String, prefixPattern: String): Int {
    for (i in 1..Int.MAX_VALUE) {
        val hash = generateMD5(secret + i)
        for (byte in hash) {
            val bytex = "%x".format(byte)
            val hex = "%02x".format(byte)
            println(hex);
        }
        val hexString = hash.toHexString()
        if (hexString.startsWith(prefixPattern)) {
            return i
        }
    }
    throw Error("Not matching hash found")
}