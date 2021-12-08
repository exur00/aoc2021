package day7

import java.io.File
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

fun main() {
    val a = File("src/day7/input.txt").readLines()
    val b = a.get(0).split(" ", ",")
    val c = IntArray(b.size)
    for (i in 0..(b.size - 1)) {c[i] = b.get(i).toInt()}
    val d = c[c.size/2 - 1]
    var e = 0
    for (i in c) {e += abs(i - d)}
    println(e)
    val s = TreeSet<Sol>()
    for (d in 0..(b.size - 1)){
        var e = 0
        for (i in c) {
            e += quickCost(abs(i - d))
//            println(i)
//            println(e)
        }
        s.add(Sol(d, e))
    }
    print(s.first().getCost())

}

fun quickCost(i: Int): Int {
    var result = 0
    for (a in 1..i) {result+= a}
    return result
}