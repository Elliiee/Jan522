import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q257 {
    // binary tree paths
    // return all root to leaf paths in any order
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<String> queueString = new LinkedList<>();

        if (root == null) return result;

        queueNode.add(root);
        queueString.add("");
        while (!queueNode.isEmpty()){
            TreeNode currentNode = queueNode.poll();
            String currentString = queueString.poll();

            if (currentNode.left == null && currentNode.right == null){
                result.add(currentString + currentNode.val);
            }

            if (currentNode.left != null){
                queueNode.add(currentNode.left);
                queueString.add(currentString + currentNode.val + "->");
            }
            if (currentNode.right != null){
                queueNode.add(currentNode.right);
                queueString.add(currentString + currentNode.val + "->");
            }
        }
        return result;
    }
}
