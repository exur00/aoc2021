package day9

import java.io.File

fun main() {
    val a = File("src/day9/input.txt").readLines()
    val grid = mutableListOf<MutableList<Int>>()
    var result = 0
    for (row in a) {
        grid.add(mutableListOf())
        for (ch in row) {
            grid.last().add(ch.toInt() - '0'.toInt())
        }
    }
    for (row in 0..(grid.size - 1))
        for (col in 0..(grid.get(row).size - 1)){
            val curr = grid.get(row).get(col)
            var lowpoint = true
            if (row > 0 && lowpoint) {lowpoint = grid.get(row - 1).get(col) > curr}
            if (col > 0 && lowpoint) {lowpoint = grid.get(row).get(col - 1) > curr}
            if (row < grid.size - 1 && lowpoint) {lowpoint = grid.get(row + 1).get(col) > curr}
            if (col < grid.get(row).size - 1 && lowpoint) {lowpoint = grid.get(row).get(col + 1) > curr}
            if (lowpoint) {result += curr + 1}
        }
    println(result)
}