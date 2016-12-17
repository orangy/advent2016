package day5

import java.security.*

fun hex(bytes: ByteArray) = bytes.map { Integer.toHexString(it.toInt() and 0xff).padStart(2, '0') }.joinToString("")

fun main(args: Array<String>) {
    val digest = MessageDigest.getInstance("MD5")
    generateSequence(0) { it + 1 }
            .map { hex(digest.digest((input + it).toByteArray())) }
            .filter { it.startsWith("00000") }
            .map { it[5] }.take(8)
            .joinToString("")
            .let { println(it) }

    val map = mutableMapOf<Char, Char>()
    generateSequence(0) { it + 1 }
            .map { hex(digest.digest((input + it).toByteArray())) }
            .filter { it.startsWith("00000") }
            .filter {
                val pos = it[5]
                if (pos !in '0'..'7' || map.containsKey(pos)) false else {
                    map[pos] = it[6]
                    true
                }
            }.take(8).toList()
    println(('0'..'7').joinToString("") { map[it]!!.toString() })
}

val input = "uqwqemis"