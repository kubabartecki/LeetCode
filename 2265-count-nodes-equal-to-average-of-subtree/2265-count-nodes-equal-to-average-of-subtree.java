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
    private int result = 0;
    public int averageOfSubtree(TreeNode root) {
        nodeAvg(root);
        return result;
    }

    // sum and number of nodes
    public Pair<Integer, Integer> nodeAvg(TreeNode node) {
        if (node == null) return new Pair<>(0, 0);
        Pair<Integer, Integer> prevR = nodeAvg(node.right);
        Pair<Integer, Integer> prevL = nodeAvg(node.left);
        int sum = prevR.getKey() + prevL.getKey() + node.val;
        int count = prevR.getValue() + prevL.getValue() + 1;
        if (sum / count == node.val) ++this.result;
        return new Pair<>(sum, count);
    }
}