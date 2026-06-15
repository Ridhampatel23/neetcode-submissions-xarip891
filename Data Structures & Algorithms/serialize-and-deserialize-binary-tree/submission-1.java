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

public class Codec {
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",", res);
    }

    private void dfs(TreeNode node, List<String> res)
    {
        if(node == null)
        {
            res.add("n");
            return;
        }

        res.add(String.valueOf(node.val));
        dfs(node.left, res);
        dfs(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return dfs2(vals);
    }

    private TreeNode dfs2(String[] vals)
    {
        if(vals[index].equals("n"))
        {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[index]));
        index++;
        node.left = dfs2(vals);
        node.right = dfs2(vals);
        return node;
    }

}
