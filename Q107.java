import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q107 {
    // binary tree level order traversal II
    // return the bottom up level order traversal
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // result uses LinkedList instead of ArrayList
        // later it could use .addFirst() to achieve the bottom-up goal
        // other steps are the same as the ordinary level order traversal
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.addFirst(level);
        }
        return result;
    }
}
