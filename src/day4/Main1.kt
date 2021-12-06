package day4


import java.io.File

fun main() {
    val a = File("src/day4/input.txt").readLines().toMutableList()
    val nums = a.get(0)
    a.removeAt(0)
    a.removeAt(0)
    val b = parse(a)
//    print(b)
    var minTurns = 100
    var minBoard = b.get(0)
    var tmp: Int
    val parsedNums = parseNums(nums)
    for (board in b) {
        tmp = board.turns(parsedNums)
        if (tmp < minTurns && tmp > 0) {
            minTurns = tmp
            minBoard = board
        }
    }
    val lastInt = parsedNums.get(minTurns - 1)
    print(minBoard.score(lastInt))









}

fun parseNums(nums: String): MutableList<Int> {
    val result = mutableListOf<Int>()
    var tmp = ""

    for (ch in nums) {
        if (ch == ',') {
            result.add(tmp.toInt())
            tmp = ""
        } else {
            tmp += ch
        }
    }
//    while (nums.length > 0) {
//        ch = nums.get(0)
//        nums.removeRange(0, 0)
//        if (ch == ',') {
//            result.add(tmp.toInt())
//            tmp = ""
//        } else {
//            tmp += ch
//        }
//    }
    return result
}

fun parse1(input: MutableList<String>): MutableList<MutableList<String>> {
    var tmp: String
    val result: MutableList<MutableList<String>> = mutableListOf()
    while (input.size > 0) {
        result.add(mutableListOf())
        while (input.size > 0 && input.get(0) != ""){
            tmp = input.get(0)
            input.removeAt(0)
            result.last().add(tmp)
        }
        if (input.size > 0) {input.removeAt(0)}
    }
    return result
}

fun parse(input: MutableList<String>): MutableList<Board> {
    val parsedIn = parse1(input)
    val result: MutableList<Board> = mutableListOf()
    for (rawBoard in parsedIn) {
        result.add(parseBoard(rawBoard))
    }
    return result
}

fun parseBoard(rawBoard: MutableList<String>): Board {
    val tmp: MutableList<MutableList<Int>> = mutableListOf()
    var str = ""
    for (row in rawBoard) {
        tmp.add(mutableListOf())
        for (char in row){
            if (char == ' ') {
                if (str != "") {
                    tmp.last().add(str.toInt())
                    str = ""
                }
            } else {
                str += char
            }
        }
        tmp.last().add(str.toInt())
        str = ""
    }
    return Board(tmp)
}

