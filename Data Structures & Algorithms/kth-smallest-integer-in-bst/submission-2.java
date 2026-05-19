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

// We can use inOrder traversal here as BST is already sorted
class Solution {
    private int count;   // tracks how many more nodes we need to skip
    private int result;  // will hold the kth smallest value once we find it

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;          // start with k remaining
        inorder(root);           // begin full in‑order traversal
        return result;           // after traversal, result holds the answer
    }

    private void inorder(TreeNode node) {
        // Stop immediately if we're at a null child,
        // OR if we’ve already found the answer (count == 0).
        // This prevents wasted recursion after we already know the answer.
        if (node == null || count == 0) {
            return;
        }

        // 1. Go left – this processes all smaller values first
        inorder(node.left);

        // After the left subtree returns, it’s possible that the answer
        // was found down there (so count became 0). If that happened,
        // we must NOT process this node again, and we must NOT go right.
        if (count == 0) {
            return;
        }

        // 2. Visit the current node – this is the “in‑order” step.
        // We decrement count BEFORE the check because we want the kth node
        // to be the one where count *becomes* 0, not was 0 before.
        count--;
        if (count == 0) {
            result = node.val;   // this is the kth smallest value
            return;              // answer found – stop completely
        }

        // 3. Go right – only if we haven’t yet found the answer.
        // (If we had found it, the count==0 check at the start of
        // this method would have prevented even entering right.)
        inorder(node.right);
    }
}