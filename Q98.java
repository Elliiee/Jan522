/*
98 Validate Binary Search Tree
Given the root of a binary tree, determine if it is a valid BST.
A valid Binary Search Tree is defined as:
1. the left subtree of a node contains only nodes with keys less than the node's key
2. the right subtree of a node contains only nodes with keys greater than the node's
key
3. both the left and right subtrees must also be binary search tree
 */
public class Q98 {
    public boolean isValidBST(TreeNode root){
        if (root == null) return true;
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer max, Integer min){
        if (root == null) return true;

        if ((max != null && root.val >= max) || (min != null && root.val <= min)){
            return false;
        }

        boolean leftBST = helper(root.left, root.val, min);
        boolean rightBST = helper(root.right, max, root.val);

        return leftBST && rightBST;
    }
}
