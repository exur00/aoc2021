package day4


import java.io.File
import kotlin.math.min

fun main() {
    val a = File("src/day4/input.txt").readLines().toMutableList()
    val nums = a.get(0)
    a.removeAt(0)
    a.removeAt(0)
    val b = parse(a)
//    print(b)
    var maxTurns = 0
    var maxBoard = b.get(0)
    var tmp: Int
    val parsedNums = parseNums(nums)
    for (board in b) {
        tmp = board.turns(parsedNums)
        if (tmp > maxTurns && tmp > 0) {
            maxTurns = tmp
            maxBoard = board
        }
    }
    val lastInt = parsedNums.get(maxTurns - 1)
    print(maxBoard.score(lastInt))









}

