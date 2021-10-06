package leetcode

fun main() {
//    val arr = intArrayOf(2,1)
//    val arr = intArrayOf(3,5,5)
    val arr = intArrayOf(0, 3, 2, 1)
    val result = ValidMountainArray().validMountainArray(arr)
    println("result: $result")
}

class ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        var prevData: Int? = null
        var upStart = false
        var downStep = false
        for (i in arr.indices) {
            val data = arr[i]
            when {
                prevData == null -> {
                    // 이전 데이터가 없으면 첫 시작이므로 데이터 넣어주고 다음으로 넘어감.
                    prevData = data
                }
                prevData == data -> {
                    // 오르막이든 내리막이든 같은 값은 mountain 이 될 수 없음.
                    return false
                }
                !downStep && prevData < data -> {
                    // 오르막이고 값이 올랐으면 계속 진행.
                    upStart = true
                    prevData = data
                }
                !downStep && prevData > data -> {
                    // 오르막이였는데 값이 내려갔으면 downStep 임을 명시
                    downStep = true
                    prevData = data
                }
                downStep && prevData > data -> {
                    // 내리막인데 값이 내려갔으면 계속 진행.
                    prevData = data
                }
                downStep && prevData < data -> {
                    // 내리막인데 값이 올라갔으면 실패.
                    return false
                }
            }
        }

        return upStart && downStep
    }
}