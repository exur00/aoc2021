package day8

import java.io.File

fun main() {
    val a = File("src/day8/input.txt").readLines()
    val allChars = setOf('a', 'b', 'c', 'd', 'e', 'f', 'g')

    for (tmp in a) {
        val b = tmp.split("|")
        val pos: HashMap<Char, Set<Char>> = HashMap()
        for (i in allChars){
            pos.put(i, hashSetOf('a', 'b', 'c', 'd', 'e', 'f', 'g'))
        }
        val c = b.get(0).split(" ")
        for (i in c){
            if (i.length == 2) {
                canBe(i, setOf('f', 'g'), pos)
            }
        }
        print("biep")


    }

}

fun canBe (first: String, second: Set<Char>, map: HashMap<Char, Set<Char>>, allChars: Set<Char>) {
    for (ch in allChars) {
        if (ch in first) {map.put(ch, map.get(ch)!!.intersect(second))}
        else {map.get(ch)!!.}
    }

}

fun canOnlyBe (first: Set<Char>, second: Set<Char>, map: HashMap<Char, Set<Char>>) {

}

