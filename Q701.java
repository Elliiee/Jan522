public class Q701 {
    // user iteration is easier to understand/ or to write the code
    // recursion
    public TreeNode insertIntoBST(TreeNode root, int val){
        if (root == null)
            return new TreeNode(val);

        if (val > root.val){
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    // Iteration
    public TreeNode insertIntoBSTII(TreeNode root, int val){
        if (root == null)
            return new TreeNode(val);

        TreeNode node = root;
        while (node != null){
            if (val > node.val){
                if (node.right == null){
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null){
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node = node.left;
                }
            }
        }

        return root;
    }
}
