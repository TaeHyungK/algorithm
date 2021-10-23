package leetcode

fun main() {
    val rowIndex = 1

    val result = PascalTriangle2Kt().getRow(rowIndex)
    println("result: $result")
}

class PascalTriangle2Kt {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) {
            return listOf(1)
        } else if (rowIndex == 1) {
            return listOf(1, 1)
        }

        val initList = listOf(1)
        var preList = initList
        for (i in 1..rowIndex) {
            val row = mutableListOf(1)
            for (j in 1 until i) {
                row.add(preList[j - 1] + preList[j])
            }
            row.add(1)

            preList = row
        }

        return preList
    }
}