package day5


import java.io.File

fun main() {
    val SIZE = 1000
    val a = File("src/day5/input.txt").readLines()
    val field: MutableList<MutableList<Int>> = MutableList(SIZE) {MutableList(SIZE) {0} }
    var result = 0
    for (line in a) {
        val b = line.split(",", " -> ")
        val c = mutableListOf<Int>()
        for (i in b) {c.add(i.toInt())}
        if(c.get(3) == c.get(1)) {
            val tmp = c.get(1)
            for (i in c.get(0)..c.get(2)) {
                val tmp2 = field.get(i).get(tmp) + 1
                if(tmp2 == 2){result ++}
                field.get(i).set(tmp, tmp2)
            }
        } else if (c.get(0) == c.get(2)) {
            val tmp = c.get(0)
            for (i in c.get(1)..c.get(3)) {
                val tmp2 = field.get(tmp).get(i) + 1
                if(tmp2 == 2){result ++}
                field.get(tmp).set(i, tmp2)
            }
        }
    }
//    print(field)
    print(result.toString() + "\n")
    result = 0

    for (row in field) {
        for (col in row) {
            if (col > 1) {result++}
        }
    }
    print(result)
}