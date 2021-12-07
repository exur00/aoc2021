package day6

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val a = File("src/day6/input.txt").readLines()
    val b = a.get(0).split(",", " ")
    var c = longArrayOf(0,0,0,0,0,0,0,0,0)
    for (i in b) {c[i.toInt()]++}
//    val t = measureTimeMillis { for (i in 1..100000000) {c = advanceFish(c)}  }
//    print(t)
//    print("\n")
    for (i in 1..256) {c = advanceFish(c)}
    print(c)
    print("\n")
    print(c.sum())



}

fun advanceFish(fishes: LongArray): LongArray {
    val result = longArrayOf(0,0,0,0,0,0,0,0,0)
    for (i in 1 .. 8) {result[i-1] = fishes[i]}
    result[6] += fishes[0]
    result[8] = fishes[0]
    return result
}