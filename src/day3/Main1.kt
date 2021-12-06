package day3


import java.io.File

fun main(){
    val a = File("src/day3/input.txt").readLines()
    val amt1 = mutableListOf<Int>()
    val length = a.get(0).length
    for(i in 0..(length - 1)){amt1.add(0)}
    for(i in a){
        for (j in 0..(length - 1))
        if(i.get(j) == '1'){
            var tmp = amt1.get(j)
            tmp++
            amt1.set(j, tmp)
        }
    }
    var gamma = ""
    for (i in amt1){
        if (i >= a.size/2){gamma += "1"}
        else {gamma += "0"}
    }
    var delta = ""
    for (i in gamma){
        when (i) {
            '1' -> delta += "0"
            '0' -> delta += "1"
        }
    }

    val gammaLong = gamma.toLong()
    val deltaLong = delta.toLong()
    print(gamma + "\n")
    print(delta + "\n")
    print(convertBinaryToDecimal(gammaLong)* convertBinaryToDecimal(deltaLong))

}

fun convertBinaryToDecimal(number: Long): Int {
    var num = number
    var decimalNumber = 0
    var i = 0
    var remainder: Long

    while (num.toInt() != 0) {
        remainder = num % 10
        num /= 10
        decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }
    print(decimalNumber)
    print("\n")
    return decimalNumber
}