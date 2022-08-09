import java.util.ArrayDeque;
import java.util.Queue;

public class Q513 {
    //find bottom left tree value
    // BFS right to left, simply return the last node's value
    // no need to keep track of the first node in the current value
    // or no need to even care about the rows at all
    // use root to traverse
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();

            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }
}
