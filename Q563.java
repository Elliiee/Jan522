public class Q563 {
    // binary tree tilt
    private int totalTilt = 0;

    private int valueSum(TreeNode node){
        if (node == null)
            return 0;

        int leftSum = valueSum(node.left);
        int rightSum = valueSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        return node.val + leftSum + rightSum; // base case
    }

    public int findTilt(TreeNode root){
        valueSum(root);
        return totalTilt;
    }
}
