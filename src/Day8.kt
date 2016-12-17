package day8

import java.io.*

fun main(args: Array<String>) {
    val (width, height) = 50 to 6
    val board = Array(width) { Array(height) { false } }
    input.lines().forEach {
        when {
            it.startsWith("rect") -> {
                val (w, h) = it.drop(5).split('x').map(String::toInt)
                (0..w - 1).forEach { x -> (0..h - 1).forEach { y -> board[x][y] = true } }
            }
            it.startsWith("rotate row y=") -> {
                val (y, d) = it.drop(13).split(" by ").map(String::toInt)
                repeat(d) {
                    val last = board[width - 1][y]
                    (width - 2 downTo 0).forEach { board[it + 1][y] = board[it][y] }
                    board[0][y] = last
                }
            }
            it.startsWith("rotate column x=") -> {
                val (x, d) = it.drop(16).split(" by ").map(String::toInt)
                board[x] = (0..height - 1).map { board[x][(it + height - d) % height] }.toTypedArray()
            }
        }
    }

    println(board.sumBy { it.count { it } })
    for (y in 0..height - 1) {
        for (x in 0..width - 1) if (board[x][y]) print("█") else print(" ")
        println()
    }
}

val input = File("input/input8").readText()
