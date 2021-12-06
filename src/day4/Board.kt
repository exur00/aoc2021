package day4

class Board(var tiles: MutableList<MutableList<Int>>) {

    fun turns(nums: MutableList<Int>): Int {
        var pos: Array<Int> = arrayOf(0, 0)
        var turns = 0
        for (num in nums) {
            turns++
            if (num in hash) {
                pos = getPos(num)
                check(pos)
                if (checkWin(pos)) {return turns}
            }
        }
        return -1
    }

    fun score(last: Int): Int {
        var result = 0
        for (row in 0 .. (tiles.size - 1)) {
            for (col in 0 .. (tiles.get(0).size - 1)) {
                if (!checked.get(row).get(col)) {result += tiles.get(row).get(col)}
            }
        }
        return (result * last)
    }

    fun check(pos: Array<Int>) {
        checked.get(pos.get(0)).set(pos.get(1), true)
        return
    }

    private fun checkWin(pos: Array<Int>): Boolean {
        return (checkRow(pos.get(0)) || checkCol(pos.get(1)))
    }

    private fun checkCol(col: Int): Boolean {
        for (row in checked) {
            if (!row.get(col)) {return false}
        }
        return true
    }

    private fun checkRow(row: Int): Boolean {
        for (check in checked.get(row)) {
            if (!check) {return false}
        }
        return true
    }

    private fun getPos(num: Int): Array<Int> {
        for (i in 0 .. (tiles.size - 1)) {
            for (j in 0 .. (tiles.first().size - 1)) {
                if (tiles.get(i).get(j) == num) {
                    return arrayOf(i, j)
                }
            }
        }
        return arrayOf(-1, -1)
    }

    fun hash() {
        hash = hashSetOf()
        for (row in tiles) {
            for (num in row){
                hash.add(num)
            }
        }
    }

    @JvmName("setTiles1")
    fun setTiles(tiles: MutableList<MutableList<Int>>) {
        this.tiles = tiles
        hash()
    }

    var checked: MutableList<MutableList<Boolean>> = mutableListOf(mutableListOf())
    lateinit var hash: HashSet<Int>

    init {
        hash()
        checked = MutableList(tiles.size) {MutableList(tiles.first().size) {false}}
    }
}