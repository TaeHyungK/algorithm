package leetcode

import java.util.*

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    val result = ReverseLinkedListKt().reverseList(head)
    println("result: $result")
}

class ReverseLinkedListKt {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val linkedList = LinkedList<ListNode>()
        var curNode = head
        do {
            linkedList.addFirst(curNode)
            curNode = curNode?.next
        } while (curNode != null)

        val dummyNode = ListNode(0)
        dummyNode.next = linkedList.first
        for (i in 1..linkedList.size) {
            val prevNode = linkedList[i - 1]
            val curNode = if (i == linkedList.size) {
                null
            } else {
                linkedList[i]
            }

            prevNode.next = curNode
        }

        curNode = dummyNode.next
        do {
            println(curNode)
            curNode = curNode?.next
        } while (curNode != null)

        return dummyNode.next
    }
}