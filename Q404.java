import java.util.LinkedList;
import java.util.Queue;

public class Q404 {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node.left != null){
                if (node.left.left == null && node.left.right == null)
                    sum += node.left.val;
                else
                    queue.offer(node.left);
            }
            if (node.right != null)
                queue.offer(node.right);
        }
        return sum;
    }
}
