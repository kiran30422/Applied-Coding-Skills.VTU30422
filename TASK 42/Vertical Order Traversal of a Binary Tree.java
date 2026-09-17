import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

    private static class NodeInfo implements Comparable<NodeInfo> {
        int row;
        int val;

        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }

        @Override
        public int compareTo(NodeInfo other) {
            if (this.row != other.row) {
                return Integer.compare(this.row, other.row);
            }
            return Integer.compare(this.val, other.val);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<NodeInfo>> map = new TreeMap<>();
        traverse(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();
        for (PriorityQueue<NodeInfo> pq : map.values()) {
            List<Integer> column = new ArrayList<>();
            while (!pq.isEmpty()) {
                column.add(pq.poll().val);
            }
            result.add(column);
        }

        return result;
    }

    private void traverse(TreeNode node, int row, int col, TreeMap<Integer, PriorityQueue<NodeInfo>> map) {
        if (node == null) {
            return;
        }

        map.putIfAbsent(col, new PriorityQueue<>());
        map.get(col).add(new NodeInfo(row, node.val));

        traverse(node.left, row + 1, col - 1, map);
        traverse(node.right, row + 1, col + 1, map);
    }
}
