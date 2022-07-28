public class Q129 {
    //sum root to leaf numbers
    // each root to leaf represents a number. return all root to leaf sum
    int totalSum = 0;

    private void preorder(TreeNode node, int currentNumber){
        if (node == null) return;

        currentNumber = currentNumber * 10 + node.val;

        if (node.left == null && node.right == null)
            totalSum += currentNumber;

        preorder(node.left, currentNumber);
        preorder(node.right, currentNumber);
    }

    public int sumNumbers(TreeNode root){
        preorder(root, 0);
        return totalSum;
    }
}
