package day6

import java.io.*

fun main(args: Array<String>) {
    input.lines().flatMap { l -> (0..7).map { it to l[it] } }.groupBy { it.first }.mapValues {
        it.value.groupBy { it.second }.mapValues { it.value.count() }.toList().sortedByDescending { it.second }.first()
    }.let { m -> (0..7).forEach { print(m[it]?.first) } }
    println()
    input.lines().flatMap { l -> (0..7).map { it to l[it] } }.groupBy { it.first }.mapValues {
        it.value.groupBy { it.second }.mapValues { it.value.count() }.toList().sortedByDescending { it.second }.last()
    }.let { m -> (0..7).forEach { print(m[it]?.first) } }


}

val input = File("input/input6").readText()