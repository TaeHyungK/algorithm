package leetcode

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)

    val result = BinaryTreePostorderTraversal().postorderTraversal(root)
    println("result: $result")
}

class BinaryTreePostorderTraversal {
    val result = mutableListOf<Int>()
    /**
     * post-order: left -> right -> root
     */
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return result
        }

        postorderTraversal(root.left)
        postorderTraversal(root.right)
        result.add(root.`val`)

        return result
    }
}