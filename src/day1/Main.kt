package day1

import java.io.File

//object Main {
    fun main() {
        val a = File("src/day1/input.txt").readLines()
        var y1 = a[0]
        var y2 : String
        val result = mutableListOf<Boolean>()
        for (tmp in a) {
            y2 = y1
            y1 = tmp
            result.add(y1 >= y2)

        }
        var x = 0
        for (tmp in result){
            if (tmp){
                x++
            }
        }
        print(x)
    }
//}