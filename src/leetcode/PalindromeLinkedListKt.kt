package leetcode

import java.util.*

fun main() {
//    val head = ListNode(1)
//    head.next = ListNode(2)
//    head.next?.next = ListNode(2)
//    head.next?.next?.next = ListNode(1)

    val head = ListNode(1)
    head.next = ListNode(2)

    val result = PalindromeLinkedListKt().isPalindrome(head)
    println("result: $result")
}

class PalindromeLinkedListKt {
    /**
     * linkedList 변수의 타입이 `LinkedList` 이면 Time Limit Exceeded로 실패하게 된다..
     * mutableList로 변경했더니 통과.. `LinkedList`가 내부적으로 속도가 더 느린가보다..!
     */
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }

        val linkedList = mutableListOf<ListNode>()

        var curNode: ListNode? = head
        while (curNode != null) {
            linkedList.add(curNode)
            curNode = curNode.next
        }

        var left = 0
        var right = linkedList.size - 1
        while (left < right) {
            if (linkedList[left].`val` != linkedList[right].`val`) {
                return false
            }

            left++
            right--
        }

        return true
    }
}