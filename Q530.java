public class Q530 {
    // min absolute difference in BST
    public int getMinDiff(TreeNode root){
        int min = Integer.MAX_VALUE;
        Integer prev = null;

        if (root == null) return min;

        getMinDiff(root.left);

        if (prev != null)
            min = Math.min(min, root.val - prev);

        prev = root.val;

        getMinDiff(root.right);

        return min;
    }
}
