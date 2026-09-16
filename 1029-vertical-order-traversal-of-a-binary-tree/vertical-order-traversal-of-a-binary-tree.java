/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, 0, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            List<NodeInfo> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NodeInfo curr = q.poll();
                level.add(curr);
                if (curr.node.left != null) {
                    q.offer(new NodeInfo(
                        curr.node.left,
                        curr.row + 1,
                        curr.col - 1
                    ));
                }
                if (curr.node.right != null) {
                    q.offer(new NodeInfo(
                        curr.node.right,
                        curr.row + 1,
                        curr.col + 1
                    ));
                }
            }
            level.sort((a, b) -> {
                if (a.col != b.col) {
                    return Integer.compare(a.col, b.col);
                }
                return Integer.compare(a.node.val, b.node.val);
            });
            for (NodeInfo curr : level) {
                map.computeIfAbsent(curr.col, k -> new ArrayList<>())
                   .add(curr.node.val);
            }
        }
        for (List<Integer> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }

    static class NodeInfo {
        TreeNode node;
        int row;
        int col;

        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}