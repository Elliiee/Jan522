import java.util.LinkedList;
import java.util.List;

/*
102 Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values.
 */
public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.pop();
                list.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
