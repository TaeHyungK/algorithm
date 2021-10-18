package leetcode

fun main() {
    val head = RandomNode(7)
    val node2 = RandomNode(13)
    val node3 = RandomNode(11)
    val node4 = RandomNode(10)
    val node5 = RandomNode(1)

    head.run {
        next = node2
        random = null
    }
    node2.run {
        next = node3
        random = head
    }
    node3.run {
        next = node4
        random = node5
    }
    node4.run {
        next = node5
        random = node3
    }
    node5.run {
        next = null
        random = head
    }

    val result = CopyListWithRandomPointer().copyRandomListOthers(head)
    println("result: $result")
}

class CopyListWithRandomPointer {
    fun copyRandomListOthers(node: RandomNode?): RandomNode? {
        var map = mutableMapOf<RandomNode, RandomNode>()

        var current: RandomNode? = node
        while (current != null) {
            map[current] = RandomNode(current.`val`)
            current = current.next
        }

        current = node
        while (current != null) {
            map[current]?.next = map[current.next]
            map[current]?.random = map[current.random]
            current = current.next
        }

        return map[node]
    }

    /**
     * 지금도 아래 코드가 왜 안되는지 이해가 안간다..
     * Random pointer of node with val 13 points to a node not in the copied list
     * 13인 노드의 random이 복사된 목록에 없는 노드를 가리킨다는데 이해가 안간다..
     */
    fun copyRandomList(node: RandomNode?): RandomNode? {
        var current: RandomNode? = node
        val copyHead = RandomNode(-1)
        var copy: RandomNode? = copyHead
        while (current != null) {
            val copyNode = RandomNode(current.`val`)
            copyNode.run {
                this.next = current?.next?.let { nextNode ->
                    RandomNode(nextNode.`val`)
                }
                this.random = current?.random?.let { randomNode ->
                    RandomNode(randomNode.`val`)
                }
            }

            copy?.next = copyNode
            copy = copy?.next
            current = current.next
        }

        var temp = copyHead.next
        while (temp != null) {
            println(temp.toString())
            temp = temp.next
        }
        return copyHead.next
    }
}

class RandomNode(var `val`: Int) {
    var next: RandomNode? = null
    var random: RandomNode? = null

    override fun toString(): String {
        return "RandomNode{ value: $`val`, next: ${next?.`val`}, random: ${random?.`val`} }"
    }
}