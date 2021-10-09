package leetcode

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    val n = 2

//    val head = ListNode(1)
//    val n = 1

//    val head = ListNode(1)
//    head.next = ListNode(2)
//    val n = 1

//    val head = ListNode(1)
//    head.next = ListNode(2)
//    val n = 2

    val result = RemoveNthNodeFromEndOfListKt().removeNthFromEnd(head, n)
    println("result: $result")
}

class RemoveNthNodeFromEndOfListKt {
    /**
     * 이전에 자바로 풀었던 것을 참고했다.. 전에도 못풀었던 것 같은데 또 못풀었다 흠..
     * 케이스 바이 케이스로 대응하려고 생각하지 말고 간단한 방법이 어떤 것이 있을지를 고민하면서 풀자.
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) {
            return null
        }

        var headForSize = head
        var size = 0
        do {
            size++
            headForSize = headForSize?.next
        } while (headForSize != null)

        var targetPosition = size - n

        val dummyNode = ListNode(0)
        dummyNode.next = head
        var prevNode: ListNode? = dummyNode
        while (targetPosition > 0) {
            targetPosition--
            prevNode = prevNode?.next
        }
        prevNode?.next = prevNode?.next?.next

        var temp = dummyNode.next
        do {
            println(temp)
            temp = temp?.next
        } while (temp != null)

        return dummyNode.next
    }
}