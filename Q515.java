import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q515 {
    public List<Integer> largestValues(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}
