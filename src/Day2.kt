package day2

import java.io.*

fun main(args: Array<String>) {
    mapOf('U' to (0 to -1), 'R' to (1 to 0), 'D' to (0 to 1), 'L' to (-1 to 0)).let { m ->
        input.lines().fold(Pair(1, 1)) { start, line ->
            line.fold(start) { c, d ->
                Pair(c.first + m[d]!!.first, c.second + m[d]!!.second).let { if (it.first in 0..2 && it.second in 0..2) it else c }
            }.apply { print("123456789"[second * 3 + first]) }
        }
    }
    println()

    mapOf('U' to (0 to -1), 'R' to (1 to 0), 'D' to (0 to 1), 'L' to (-1 to 0)).let { m ->
        input.lines().fold(Pair(0, 2)) { start, line ->
            line.fold(start) { c, dir ->
                Pair(c.first + m[dir]!!.first, c.second + m[dir]!!.second).let {
                    val xshift = Math.abs(2 - it.second)
                    val yshift = Math.abs(2 - it.first)
                    if (it.first in (xshift..(4 - xshift)) && it.second in (yshift..(4 - yshift))) it else c
                }
            }.apply { print("??1???234?56789?ABC???D??"[second * 5 + first]) }
        }
    }
}

val input = File("input/input2").readText()