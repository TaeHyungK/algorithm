package leetcode

import java.util.*

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(6)
    head.next?.next?.next = ListNode(3)
    head.next?.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next?.next = ListNode(6)
    val n = 6

//    val head = ListNode(7)
//    head.next = ListNode(7)
//    head.next?.next = ListNode(7)
//    head.next?.next?.next = ListNode(7)
//    val n = 7

    val result = RemoveLinkedListElements().removeElements(head, n)
    println("result: $result")

    val resultOther = RemoveLinkedListElements().removeElementsOther(head, n)
    println("resultOther: $resultOther")
}

class RemoveLinkedListElements {
    fun removeElementsOther(head: ListNode?, n: Int): ListNode? {
        val dummyNode = ListNode(0)
        dummyNode.next = head

        var prevNode = dummyNode
        var curNode = head

        while (curNode != null) {
            if (curNode.`val` == n) {
                prevNode.next = curNode.next
            } else {
                prevNode = curNode
            }
            curNode = curNode.next
        }
        return dummyNode.next
    }

    /**
     * 링크드 리스트를 굳이 만들지 않아도 바로 removeElementsOther() 메소드 처럼 while문을 돌면서 바로 건너뛸 수 있다..!
     */
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return null
        }

        val linkedListElements = LinkedList<ListNode>()
        var curNode = head
        do {
            curNode?.let {
                if (it.`val` != `val`) {
                    linkedListElements.add(it)
                }
            }
            curNode = curNode?.next
        } while (curNode != null)

        if (linkedListElements.isEmpty()) {
            return null
        }

        val dummyNode = ListNode(0)
        dummyNode.next = linkedListElements.first
        for (i in 1..linkedListElements.size) {
            val preNode = linkedListElements[i - 1]
            val curNode = if (i == linkedListElements.size) {
                null
            } else {
                linkedListElements[i]
            }

            preNode.next = curNode
        }

        curNode = dummyNode.next
        do {
            println(curNode)
            curNode = curNode?.next
        } while (curNode != null)

        return dummyNode.next
    }
}