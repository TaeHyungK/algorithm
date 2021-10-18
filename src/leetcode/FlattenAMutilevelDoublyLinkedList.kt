package leetcode

fun main() {
    val head = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node6 = Node(6)
    val node7 = Node(7)
    val node8 = Node(8)
    val node9 = Node(9)
    val node10 = Node(10)
    val node11 = Node(11)
    val node12 = Node(12)

    head.next = node2
    node2.run {
        prev = head
        next = node3
    }
    node3.run {
        prev = node2
        next = node4
        child = node7
    }
    node4.run {
        prev = node3
        next = node5
    }
    node5.run {
        prev = node4
        next = node6
    }
    node6.run {
        prev = node5
    }
    node7.run {
        next = node8
    }
    node8.run {
        prev = node7
        next = node9
        child = node11
    }
    node9.run {
        prev = node8
        next = node10
    }
    node10.run {
        prev = node9
    }
    node11.run {
        next = node12
    }
    node12.run {
        prev = node11
    }

    val result = FlattenAMutilevelDoublyLinkedList().flatten(head)
    println("result: $result")
}

class FlattenAMutilevelDoublyLinkedList {
    /**
     * 문제를 보고 초장부터 겁을 먹었는데 해설을 보고서 코드 독해를 해보니
     * 복잡한 생각 없이 논리의 흐름(?) 대로 하면 되는 문제였다.
     * 알고리즘에 대한 막연한 두려움이 있는데 깨보자..
     */
    fun flatten(root: Node?): Node? {
        var current = root
        while (current != null) {
            current.child?.let {
                // child가 없는 경우 next를 이음
                val flatten = current // child를 호출한 노드
                val next = flatten?.next // child를 호출한 노드의 next 노드
                var childLastNode: Node? = it // child 노드의 마지막 노드
                while (childLastNode?.next != null) {
                    childLastNode = childLastNode.next
                }
                flatten?.next = it
                it.prev = flatten
                flatten?.child = null
                childLastNode?.next = next
                next?.let { node ->
                    node.prev = childLastNode
                }
            }
            current = current.next
        }
        return root
    }
}

class Node(var value: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}