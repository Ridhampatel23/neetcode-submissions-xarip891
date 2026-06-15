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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                res.append("N,");
            } else {
                res.append(curr.val + ",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if(vals[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < vals.length; i++){
            TreeNode parent = q.poll();
            if(!vals[i].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                parent.left = left;
                q.add(left);
            }

             if(!vals[++i].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
