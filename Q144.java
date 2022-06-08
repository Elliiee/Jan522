import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> output = new LinkedList<>();
        if (root == null)
            return output;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);

            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }

        return output;
    }

    public List<Integer> preorderTraversalII(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null)
                stack.add(current.right);
            if (current.left != null)
                stack.add(current.left);
        }
        return result;
    }
}
