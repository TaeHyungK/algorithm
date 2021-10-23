package leetcode

fun main() {
    val s = charArrayOf('h', 'e', 'l', 'l', 'o')

    val result = ReverseStringKt().reverseString(s)

    println("result")
    s.forEach {
        println(it)
    }
}

class ReverseStringKt {
    /**
     * 재귀도 아래와 똑같다. 맨앞과 맨뒤를 바꿔주면서 가운데로 수렴해가도록 함.
     */
    fun reverseString(s: CharArray): Unit {
        reverse(0, s.size - 1, s)
    }

    private fun reverse(leftPosition: Int, rightPosition: Int, s: CharArray) {
        if (leftPosition > rightPosition) {
            return
        }
        val temp = s[leftPosition]
        s[leftPosition] = s[rightPosition]
        s[rightPosition] = temp
        reverse(leftPosition + 1, rightPosition - 1, s)
    }

    /**
     * 반으로 쪼개서 앞과 뒤를 바꿔준다.
     */
//    fun reverseString(s: CharArray): Unit {
//        val midPosition = s.size / 2 - 1
//        if (midPosition < 0) {
//            return
//        }
//        val lastSize = s.size - 1
//        var reverseIndex = lastSize
//        for (i in 0..midPosition) {
//            val temp = s[i]
//            s[i] = s[reverseIndex]
//            s[reverseIndex] = temp
//            reverseIndex--
//        }
//        s.forEach {
//            println(it)
//        }
//    }
}