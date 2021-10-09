package leetcode

fun main() {
//    val headA = ListNode(4)
//    headA.next = ListNode(1)
//    headA.next?.next = ListNode(8)
//    headA.next?.next?.next = ListNode(4)
//    headA.next?.next?.next?.next = ListNode(5)
//
//    val headB = ListNode(5)
//    headB.next = ListNode(6)
//    headB.next?.next = ListNode(1)
//    headB.next?.next = headA.next?.next

//    val headA = ListNode(1)
//    headA.next = ListNode(9)
//    headA.next?.next = ListNode(1)
//    headA.next?.next?.next = ListNode(2)
//    headA.next?.next?.next?.next = ListNode(4)
//
//    val headB = ListNode(3)
//    headB.next = headA.next?.next?.next

//    val headA = ListNode(2)
//    headA.next = ListNode(6)
//    headA.next?.next = ListNode(4)
//
//    val headB = ListNode(1)
//    headB.next = ListNode(5)

//    val headA = ListNode(1)
//    val headB = headA

    val headA = ListNode(3)
    val headB = ListNode(2)
    headB.next = headA

    val result = IntersectionOfTwoLinkedListsKt().getIntersectionNode(headA, headB)
    println("result: $result")
}

class IntersectionOfTwoLinkedListsKt {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var curANode = headA
        do {
            var curBNode = headB
            do {
                if (curANode == curBNode) {
                    return curANode
                }

                curBNode = curBNode?.next
            } while (curBNode != null)

            curANode = curANode?.next
        } while (curANode != null)

        return null
    }
}