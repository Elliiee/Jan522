import java.util.ArrayDeque;
import java.util.Queue;

public class Q1602 {
    // find near-est right node in binary tree
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if (node == u){
                    if (i == size - 1)
                        return null;
                    else
                        return queue.peek();
                }

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return null;
    }
}
