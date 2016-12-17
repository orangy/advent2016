package day1

import java.io.*

fun main(args: Array<String>) {
    listOf(0 to -1, 1 to 0, 0 to 1, -1 to 0).let { m ->
        input.split(", ").map { it.first() to it.drop(1).toInt() }.fold(Triple(0, 0, 0)) { (x, y, d), (r, l) ->
            (if (r == 'R') (d + 1) % 4 else (d + 3) % 4).let { nd ->
                Triple(x + m[nd].first * l, y + m[nd].second * l, nd)
            }
        }.let { println(Math.abs(it.first) + Math.abs(it.second)) }
    }

    listOf(0 to -1, 1 to 0, 0 to 1, -1 to 0).let { m ->
        val visited = mutableSetOf(0 to 0)
        input.split(", ").map { it.first() to it.drop(1).toInt() }.fold(Triple(0, 0, 0)) { (x, y, d), (r, l) ->
            (if (r == 'R') (d + 1) % 4 else (d + 3) % 4).let { nd ->
                (1..l).forEach {
                    Pair(x + m[nd].first * it, y + m[nd].second * it).apply {
                        if (!visited.add(this)) println(Math.abs(first) + Math.abs(second))
                    }
                }
                Triple(x + m[nd].first * l, y + m[nd].second * l, nd)
            }
        }
    }
}

val input = File("input/input1").readText()