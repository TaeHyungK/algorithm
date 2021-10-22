package leetcode

fun main() {
//    val root = TreeNode(5)
//    root.left = TreeNode(4)
//    root.left?.left = TreeNode(11)
//    root.left?.left?.left = TreeNode(7)
//    root.left?.left?.right = TreeNode(2)
//    root.right = TreeNode(8)
//    root.right?.left = TreeNode(13)
//    root.right?.right = TreeNode(4)
//    root.right?.right?.right = TreeNode(1)
//    val targetSum = 22

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    val targetSum = 5

    val result = PathSum().hasPathSum(root, targetSum)

    println("result: $result")
}

class PathSum {
    /**
     * wow.. 잘 안돼서 결국 답을 봤는데 아쉽다..
     * leaf node에 도달했을 때 총 합이 targetSum과 같으면 true를 반환한다.
     * left와 right는 `||` 로 묶어서 돈다.. <- 이게 핵심인 것 같은데 신기하다..
     */
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }

        if (root.left == null && root.right == null && root.`val` == targetSum) {
            return true
        }

        return depthSum(root.left, root.`val`, targetSum) || depthSum(root.right, root.`val`, targetSum)
    }

    private fun depthSum(root: TreeNode?, sum: Int, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }

        val result = sum + root.`val`
        if (root.left == null && root.right == null) {
            return result == targetSum
        }

        return depthSum(root.left, result, targetSum) || depthSum(root.right, result, targetSum)
    }
}