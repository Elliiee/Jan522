import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q145 {
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                result.addFirst(current.val);
                current = current.right;
            } else {
                TreeNode node = stack.pop();
                current = node.left;
            }
        }
        return result;
    }
}
