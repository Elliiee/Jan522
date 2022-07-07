import java.util.LinkedList;
import java.util.Queue;

public class Q226 {
    // invert binary tree
    public TreeNode invertTree(TreeNode root){
        // iterative
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        return root;
    }

    // recursion
}
