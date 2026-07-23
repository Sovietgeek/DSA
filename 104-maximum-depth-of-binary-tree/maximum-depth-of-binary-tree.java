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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Left sub-tree aur Right sub-tree ki max depth nikalo
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Current node ki depth (+1) add karke maximum return karo
        return 1 + Math.max(leftDepth, rightDepth);
    }
}