package leetcode

fun main() {
    val arr = intArrayOf(17,18,5,4,6,1)
//    val arr = intArrayOf(400)
//    val arr = intArrayOf(56903,18666,60499,57517,26961)
//    val arr = intArrayOf(57010,40840,69871,14425,70605)
    val result = ReplaceElementsWithGreatestElementOnRightSide().replaceElementsOther(arr)
    println("result: $result")
}

class ReplaceElementsWithGreatestElementOnRightSide {
    fun replaceElementsOther(arr: IntArray): IntArray {
        var max = arr[arr.size - 1]
        arr[arr.size - 1] = -1

        if (arr.size == 1) {
            return arr
        }

        for (i in arr.size - 2 downTo 0) {
            val newMax = arr[i].coerceAtLeast(max)
            arr[i] = max
            max = newMax
        }

        arr.forEach {
            println(it)
        }

        return arr
    }

//    fun replaceElements(arr: IntArray): IntArray {
//        if (arr.size <= 1) {
//            arr[0] = -1
//            return arr
//        }
//
//        var max: Int? = null
//        var prevData: Int? = null
//        loop@ for (i in arr.size - 1 downTo 0) {
//            val data = arr[i]
//            when {
//                max == null && prevData == null -> {
//                    arr[i] = -1
//                }
//                max == null && prevData != null -> {
//                    arr[i] = prevData
//                    max = data.coerceAtLeast(prevData)
//                }
//                else -> {
//                    max?.let { maxData ->
//                        prevData?.let { prevData ->
//                            arr[i] = maxData.coerceAtLeast(prevData)
//                            max = arr[i]
//                        }
//                    }
//                }
//            }
//            prevData = data
//        }
//
//        arr.forEach {
//            println(it)
//        }
//
//        return arr
//    }
}