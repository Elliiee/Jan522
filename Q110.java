public class Q110 {
    //Given a binary tree, determine if it is height balanced
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
