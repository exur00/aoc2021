package day5


import java.io.File
import java.lang.Integer.min
import java.lang.Math.max

fun main() {
    val a = File("src/day5/input.txt").readLines()
    var result = 0
    val once = hashSetOf<Point>()
    val twice = hashSetOf<Point>()
    for (line in a) {
        val b = line.split(",", " -> ")
        val c = mutableListOf<Int>()
        for (i in b) {c.add(i.toInt())}
        if(c.get(3) == c.get(1)) {
            val tmp = c.get(1)
            for (i in min(c.get(0), c.get(2))..max(c.get(0), c.get(2))) {
                if(checkAndAdd(Point(i, tmp), once, twice)) {result++}
            }
        } else if (c.get(0) == c.get(2)) {
            val tmp = c.get(0)
            for (i in min(c.get(1), c.get(3))..max(c.get(1), c.get(3))) {
                if(checkAndAdd(Point(tmp, i), once, twice)) {result++}
            }
        }
    }
    print(result)

}