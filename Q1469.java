import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1469 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node.left == null && node.right != null)
                result.add(node.right.val);
            if (node.left != null && node.right == null)
                result.add(node.left.val);

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return result;
    }
}
