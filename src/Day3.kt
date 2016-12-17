package day3

import java.io.*

fun main(args: Array<String>) {
    listOf(listOf(0, 1, 2), listOf(0, 2, 1), listOf(1, 2, 0)).let { m ->
        input.lines().map { it.split(" ").filter(String::isNotEmpty).map(String::toInt) }.let { l ->
            println(l.count { a -> m.all { a[it[0]] + a[it[1]] > a[it[2]] } })
        }
    }

    input.split(" ", "\n").filter(String::isNotEmpty).map(String::toInt).let { l ->
        listOf(listOf(0, 1, 2), listOf(0, 2, 1), listOf(1, 2, 0)).let { m ->
            println((0 until l.size / 9).flatMap { g -> (0..2).map { listOf(l[g * 9 + it], l[g * 9 + 3 + it], l[g * 9 + 6 + it]) } }
                    .count { a -> m.all { a[it[0]] + a[it[1]] > a[it[2]] } })
        }
    }
}

val input = File("input/input3").readText()