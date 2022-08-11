public class Q687 {
    //longest uni-value path
    // given the root of a binary tree, return the length of the longest path, where each node in the
    // path has the same value. The path may or may not pass through the root.
    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root){
        if (root == null) return 0;
        getDepth(root, root.val);
        return maxLength;
    }

    private int getDepth(TreeNode node, int value){
        if (node == null) return 0;
        int left = getDepth(node.left, node.val);
        int right = getDepth(node.right, node.val);
        maxLength = Math.max(maxLength, left + right);

        if (value == node.val)
            return Math.max(left, right) + 1;

        return 0;
    }
}
