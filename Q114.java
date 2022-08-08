public class Q114 {
    // flatten binary tree to linked list
    public void flatten(TreeNode root){
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node){
        if (node == null) return null;

        if (node.left == null && node.right == null)
            return node; // for a leaf node, we simply return the node.

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        if (leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }
}
