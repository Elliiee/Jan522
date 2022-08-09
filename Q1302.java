import java.util.ArrayDeque;
import java.util.Queue;

public class Q1302 {
    //deepest leaves sum
    // typical BFS, key point is to reset the sum for each level
    // the answer is the last level sum

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return sum;
    }
}
