package day8

import java.io.File

fun main() {
    var result = 0
    val lengthSet = setOf(2, 3, 4, 7)

    val a = File("src/day8/input.txt").readLines()
    for (tmp in a) {
        val b = tmp.split("|")
        val c = b.get(1).split(" ")
        for (i in c){
            if (lengthSet.contains(i.length)) {
                result++
            }
        }
    }
    print(result)
}