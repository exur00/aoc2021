package day2

import java.io.File

fun main(){
    val a = File("src/day2/input.txt").readLines()

    var depth = 0
    var x = 0
    var aim = 0
    for(i in a){
        when(i.get(0)){
//            'f' -> x+= i.get(i.length-1).toString().toInt()
            'f' -> {
                x+= i.get(i.length-1).toString().toInt()
                depth += (aim * i.get(i.length-1).toString().toInt())
            }
            'd' -> aim+=i.get(i.length-1).toString().toInt()
            'u' -> aim-=i.get(i.length-1).toString().toInt()
        }
    }
    print(depth*x)

}