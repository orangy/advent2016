package day7

import java.io.*

fun main(args: Array<String>) {
    input.lines().map {
        it.split('[', ']').mapIndexed { i, s ->
            Triple(s, i, (0..s.lastIndex - 3).any { s[it] != s[it + 1] && s[it] == s[it + 3] && s[it + 1] == s[it + 2] })
        }
    }.filter { it.any { it.third && (it.second % 2 == 0) } && it.none { it.third && (it.second % 2 == 1) } }.count().let { println(it) }

    input.lines().map { it.split('[', ']').mapIndexed { i, s -> s to i } }
            .filter { segments ->
                val seqs = segments.filter { it.second % 2 == 0 }.flatMap { (s, _) ->
                    (0..s.lastIndex - 2).filter { s[it] != s[it + 1] && s[it] == s[it + 2] }.map { "${s[it + 1]}${s[it]}${s[it + 1]}" }
                }
                segments.any { (s, i) -> i % 2 == 1 && seqs.any { it in s } }
            }.count().let { println(it) }
}

val input = File("input/input7").readText()
