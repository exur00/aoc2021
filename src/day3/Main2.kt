package day3


import java.io.File

fun main(){
    var a = File("src/day3/input.txt").readLines()
    var tmp1 = mutableListOf<String>()
    var tmp0 = mutableListOf<String>()
    var j = 0
    while (a.size > 1) {
        for(i in a){
            when(i.get(j)){
                '0' -> tmp0.add(i)
                '1' -> tmp1.add(i)
            }
        }
        if (tmp1.size >= tmp0.size){a = tmp1}
        else {a = tmp0}
        tmp1 = mutableListOf()
        tmp0 = mutableListOf()
        j++
    }
    val oxGenRating = convertBinaryToDecimal(a.get(0).toLong())

    //just ignore the duplicate code

    a = File("src/day3/input.txt").readLines()
    tmp1 = mutableListOf<String>()
    tmp0 = mutableListOf<String>()
    j = 0
    while (a.size > 1) {
        for(i in a){
            when(i.get(j)){
                '0' -> tmp0.add(i)
                '1' -> tmp1.add(i)
            }
        }
        if (tmp1.size < tmp0.size){a = tmp1}
        else {a = tmp0}
        tmp1 = mutableListOf()
        tmp0 = mutableListOf()
        j++
    }
    val co2ScrubRating = convertBinaryToDecimal(a.get(0).toLong())
    print(oxGenRating * co2ScrubRating)
}