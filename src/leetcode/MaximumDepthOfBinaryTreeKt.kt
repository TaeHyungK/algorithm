package leetcode

import kotlin.math.max

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val result = MaximumDepthOfBinaryTreeKt().maxDepth(root)
    println("result: $result")
}

class MaximumDepthOfBinaryTreeKt {
    var result = 0
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return result
        }

        return maxDepth(root, 1)
    }

    private fun maxDepth(root: TreeNode?, depth: Int): Int {
        if (root == null) {
            return result
        }

        result = max(result, depth)
        if (root.left == null && root.right == null) {
            return result
        }

        maxDepth(root.left, depth + 1)
        maxDepth(root.right, depth + 1)

        return result
    }
}