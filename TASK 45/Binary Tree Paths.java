import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            constructPaths(root, "", result);
        }
        return result;
    }

    private void constructPaths(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }

        path += node.val + "->";
        if (node.left != null) {
            constructPaths(node.left, path, result);
        }
        if (node.right != null) {
            constructPaths(node.right, path, result);
        }
    }
}
