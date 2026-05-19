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
    private int count;
    private int result;

    // We can use inorder traversal here as the bst is already sorted
    // Easier chance to get the smaller element in that manner
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null || count == 0) return;  // stop if found

        inorder(node.left);
        // after left, check if already found
        if (count == 0) return;

        // visit current
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }

        inorder(node.right);
    }
}
