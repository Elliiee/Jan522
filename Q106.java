import java.util.HashMap;

public class Q106 {
    private int post_idx;
    private int[] postorder;
    private int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int in_left, int in_right){
        if (in_left > in_right)
            return null; // there is no elements to construct the subtree

        // last element of the postorder is the root value
        // get the root value and construct the new tree
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // get the index of the root value at inorder traversal
        int index = idx_map.get(root_val);

        post_idx--; // recursion (it will be the next "root")

        // build right first because of the postorder
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.postorder = postorder;
        this.inorder = inorder;
        post_idx = postorder.length - 1; // get the root node index at postorder

        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);

        return helper(0, inorder.length - 1);
    }
}
