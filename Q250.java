public class Q250 {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root){
        isUnival(root, 0);
        return count;
    }

    public boolean isUnival(TreeNode node, int val){
        // base case, consider a valid subtree
        if (node == null){
            return true;
        }

        //note that || short circuits but | does not -
        // both sides of the or get evaluated with | so we explore all possible routes
        if (!isUnival(node.left, node.val) | isUnival(node.right, node.val))
            return false;

        count++;
        return node.val == val;
    }
}
