package leetcode

import java.util.*

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val result = BinaryTreeLevelOrderTraversalKt().levelOrder(root)
    println("result: $result")
}

class BinaryTreeLevelOrderTraversalKt {
    /**
     * BFS.
     * 아직도 BFS 하는 방법이 헷갈린다..
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (!queue.isEmpty()) {
            val levelQueue = mutableListOf<Int>()
            val size = queue.size

            for (i in 0 until size) {
                val node = queue.poll()
                levelQueue.add(node.`val`)

                node.left?.let {
                    queue.offer(it)
                }
                node.right?.let {
                    queue.offer(it)
                }
            }
            result.add(levelQueue)
        }

        return result
    }
}