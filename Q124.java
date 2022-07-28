public class Q124 {
    // binary tree max path sum
    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node){
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // the price to start a new path where node is the new root node
        int priceNewPath = node.val + leftGain + rightGain;

        // update max sum if the new path has larger value sum
        maxSum = Math.max(maxSum, priceNewPath);

        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }
}
