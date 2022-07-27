public class Q543 {
    //diameter of binary tree
    private int max = 0;

    private int longestPath(TreeNode node){
        if (node == null)
            return 0;

        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);
        max = Math.max(max, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root){
        longestPath(root);
        return max;
    }
}
