package leetcode

fun main() {
    val result = ClimbingStairsKt().climbStairs(2)
    println("result: $result")
}

class ClimbingStairsKt {
    /**
     * 1 -> 1 => 1개
     * 2 -> 11, 2 => 2개
     * 3 -> 111, 12, 21 => 3개
     * 4 -> 1111, 112, 121, 211, 22 => 5개
     * 5 -> 11111, 1112, 1121, 1211, 2111, 122, 212, 221 => 8개
     *
     * 3부터는 앞에 두개의 정답을 합치면 된다.
     */
    fun climbStairs(n: Int): Int {
        val list = mutableListOf(1, 2)
        for (i in 2 until n) {
            list.add(list[i - 2] + list[i - 1])
        }
        return list[n - 1]
    }
}