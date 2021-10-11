package leetcode

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

//    val result = OddEvenLinkedListKt().oddEvenList(head)
//    println("result: $result")

    val resultOther = OddEvenLinkedListKt().oddEvenListOther(head)
    println("resultOther: $resultOther")
}

class OddEvenLinkedListKt {
    fun oddEvenListOther(head: ListNode?): ListNode? {
        var odd: ListNode? = head
        var even: ListNode? = head?.next
        val evenHead = even

        var current: ListNode? = head?.next?.next
        var count = 3
        while (current != null) {
            if (count % 2 != 0) {
                odd?.next = current
                odd = current
            } else {
                even?.next = current
                even = current
            }
            count++
            current = current.next
        }

        even?.next = null
        odd?.next = evenHead

        var logHead = head
        do {
            println(logHead)
            logHead = logHead?.next
        } while (logHead != null)

        return head
    }

    /**
     * Other와 비교해보았을 때 생각의 흐름?은 비슷한데 runtime 시간은 길다.. 흐음..
     */
    fun oddEvenList(head: ListNode?): ListNode? {
        val dummyNode = ListNode(-1)
        dummyNode.next = head

        val oddDummy = ListNode(-1)
        var oddNode: ListNode? = oddDummy

        val evenDummy = ListNode(-1)
        var evenNode: ListNode? = evenDummy

        var curNode: ListNode? = dummyNode
        var index = 0
        while (curNode != null) {
            if (index % 2 == 0) {
                evenNode?.next = curNode
                evenNode = evenNode?.next

                oddNode?.next = null
            } else {
                oddNode?.next = curNode
                oddNode = oddNode?.next

                evenNode?.next = null
            }

            index++
            curNode = curNode.next
        }

        oddNode?.next = evenDummy.next?.next

        var resultNode = oddDummy.next
        do {
            println(resultNode)
            resultNode = resultNode?.next
        } while (resultNode != null)

        return oddDummy.next
    }
}