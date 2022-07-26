public class Q270 {
    // closest binary search tree value
    // given the root of a binary search tree and a target value,
    // return the value in the bst that is closest to the target
    public int closestValue(TreeNode root, double target){
        int result = root.val;
        TreeNode node = root;
        while (node != null){
            if (Math.abs(target - node.val) < Math.abs(target - result))
                result = node.val;
            node = node.val > target? node.left : node.right;
        }
        return result;
    }
}
