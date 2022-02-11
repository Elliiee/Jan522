import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
94 Binary Tree Inorder Traversal
Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();

        if (root == null)
            return output;

        TreeNode current = root;

        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop(); // 指针的作用改变成用来获取每一个值了
            output.add(current.val);
            current = current.right;
        }

        return output;
    }
}
