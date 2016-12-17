package day4

import java.io.*
import kotlin.comparisons.*

fun main(args: Array<String>) {
    val rooms = input.lines().map {
        val (s, h) = it.substringAfterLast("-").split("[", "]")
        val r = it.substringBeforeLast("-")
        val cs = r.replace("-", "").groupBy { it }
                .mapValues { it.value.count() }.toList()
                .sortedWith(compareByDescending<Pair<Char, Int>> { it.second }.thenBy { it.first })
                .take(5).joinToString("") { it.first.toString() }
        Triple(r, s.toInt(), h == cs)
    }.filter { it.third }

    rooms.sumBy { it.second }.let { println(it) } // 361724
    rooms.map { (r, id, _) ->
        r.map { if (it == '-') ' ' else ((((it.toInt() - 'a'.toInt()) + id) % 26) + 'a'.toInt()).toChar() }.joinToString("") to id
    }.filter { it.first == "northpole object storage" }.single().let { println(it) }
    //(northpole object storage, 482)
}

val input = File("input/input4").readText()