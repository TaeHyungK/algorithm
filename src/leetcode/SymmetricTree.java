package leetcode;

public class SymmetricTree {
    public static void main(String[] args) {
        isSymmetric(new TreeNode());
    }

    public static boolean isSymmetric(TreeNode root) {
        // 첫번째 풀이
        // 리스트로 만들어서 null을 포함해서 리스트로 구성한 후
        // 2^(n - 1) ~ 2^n 인덱스 위치 확인하는 것으로 해보기.
        //  -> null 값을 포함해서 넣는 방법을 모르겠다..
//        boolean result = true;
//        List<List<Integer>> list = new ArrayList<>();
//        if (root == null) return true;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            List<Integer> levelQueue = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll(); // 큐에서 노드 꺼내옴
//                if (node != null) levelQueue.add(node.val); // 꺼내온 노드의 값을 저장
//                else levelQueue.add(null);
//
//                if (node.left != null) {
//                    queue.add(node.left); // 해당 노드에 left가 있으면 큐에 추가
//                }
//                if (node.right != null) { // 해당 노드에 right가 있으면 큐에 추가
//                    queue.add(node.right);
//                }
//            }
//            list.add(levelQueue);
//        }
//
//        System.out.println(list.toString());
//
//        return result;

        // 두번째 풀이
        // 정답을 본 후..
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (right == null || left == null) {
            return false;
        }

        if (left.val != right.val)
            return false;

        if (!isSymmetric(left.left, right.right))
            return false;
        if (!isSymmetric(left.right, right.left))
            return false;

        return true;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
