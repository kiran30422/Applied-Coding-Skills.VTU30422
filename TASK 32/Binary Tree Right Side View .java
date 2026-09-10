import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = queue.poll();

                // Last node of each level
                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                // Add left child
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add right child
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
}
