package day1

import java.io.File

fun main(){
    val a = File("src/day1/input.txt").readLines()

    var y1 = a.get(2).toInt()
    var y2 = a.get(1).toInt()
    var y3 = a.get(0).toInt()
    var result = 0
    for(i in 3 ..(a.size - 1)){
        if ((y1 + y2 + y3) < (y2 + y1 + a.get(i).toInt())){result++}
        y3 = y2
        y2 = y1
        y1 = a.get(i).toInt()
    }
    print(result)

}