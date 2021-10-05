package leetcode

fun main() {
    val solution = Solution()
    val arr = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
    solution.duplicateZeros(arr)
}

class Solution {
    /**
     * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
     *
     * 복잡하게 생각하지 말고 간단하게 생각하자..!
     */
    fun duplicateZeros(arr: IntArray) {
        var skip = false
        arr.forEachIndexed { index, data ->
            if (skip) {
                skip = false
                return@forEachIndexed
            }
            if (data == 0) {
                for (i in arr.size - 1 downTo index + 1) {
                    arr[i] = arr[i - 1]
                }
                skip = true
            }
        }

        arr.forEach {
            println(it)
        }
    }
}