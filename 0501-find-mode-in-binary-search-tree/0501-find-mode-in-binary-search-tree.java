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
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        int streak = 0;
        int maxStreak = 0;
        int currNum = 1_000_000; // not reachable number
        TreeNode current = root;
        boolean newMode = false;

        while (current != null) {
            if (current.left != null) {
                TreeNode prevMax = current.left;
                while (prevMax.right != null) prevMax = prevMax.right;
                prevMax.right = current;
                current = current.left;
                prevMax.right.left = null;  
            } else {
                if (current.val == currNum){
                    ++streak;
                } 
                else {
                    
                    newMode = true;
                    streak = 0;
                    currNum = current.val;
                }
                if (streak == maxStreak) modes.add(current.val);
                else if (streak > maxStreak) {
                    if (newMode) {
                        newMode = false;
                        modes.clear();
                        modes.add(current.val);
                    }
                    maxStreak = streak;
                }
                current = current.right;
            }
        }

        int [] result = modes.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}