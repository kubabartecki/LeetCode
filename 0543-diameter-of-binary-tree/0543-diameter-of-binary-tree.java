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
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxNodeDiameter(root);
        return this.max;
    }

    public int maxNodeDiameter(TreeNode node) {
        int right = 0;
        int left = 0;
        if (node.left != null) {
            left = maxNodeDiameter(node.left) + 1;
        }
        if (node.right != null) {
            right = maxNodeDiameter(node.right) + 1;
        }
        int diameter = right + left;
        if (diameter > this.max) {
            this.max = diameter;
        }
        return Math.max(right, left);
    }
}
