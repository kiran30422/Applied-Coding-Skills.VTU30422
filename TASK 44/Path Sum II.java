import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        
        currentPath.add(node.val);

        
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        } else {
            
            int remainingSum = targetSum - node.val;
            findPaths(node.left, remainingSum, currentPath, result);
            findPaths(node.right, remainingSum, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
