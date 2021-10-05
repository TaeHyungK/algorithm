package leetcode

fun main() {
    val solution = MergeSortedArrayKt()

    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val m = 3
    val nums2 = intArrayOf(2, 5, 6)
    val n = 3
    solution.merge(nums1, m, nums2, n)
}

class MergeSortedArrayKt {
    /**
     * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
     *
     * j 를 같이 사용할 때에는 withIndex() 라는 Api로 쉽게 j+=1 처리를 해줄 수 있다.
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for ((j, i) in (m until m + n).withIndex()) {
            nums1[i] = nums2[j]
        }
        nums1.sort()

        nums1.forEach {
            println(it)
        }
    }
}