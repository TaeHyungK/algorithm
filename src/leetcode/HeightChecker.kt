package leetcode

fun main() {
//    val heights = intArrayOf(1,1,4,2,1,3)
//    val heights = intArrayOf(5,1,2,3,4)
//    val heights = intArrayOf(1,1,1,1,1,1,1,1)
    val heights = intArrayOf(2,1,2,1,1,2,2,1)
    val result = HeightChecker().heightChecker(heights)
    println("result: $result")
}

class HeightChecker {
    fun heightChecker(heights: IntArray): Int {
        val sortedArr = heights.clone()
        sortedArr.sort()

        var result = 0
        heights.forEachIndexed { index, height ->
            if (height != sortedArr[index]) {
                result++
            }
        }
        return result
    }
}