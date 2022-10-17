import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExploreLearCardBinaryTree {
    /*
    Preorder traversal
     */
    public void preorder(TreeNode root, List<Integer> result){
        if (root != null){
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }

    public void inorder(TreeNode root, List<Integer> result){
        if (root != null){
            preorder(root.left, result);
            result.add(root.val);
            preorder(root.right, result);
        }
    }

    public void postorder(TreeNode root, List<Integer> result){
        if (root != null){
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }

    /*
    Maximum depth of binary tree
     */
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1; // add 1 level for the root
    }

    /*
    Symmetric Tree
     */
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root){
        return isMirror(root, root);
    }

    /*
    Path Sum
     */
    public boolean hasPathSum(TreeNode root, int target){
        if (root == null) return false;

        target -= root.val;

        if (root.left == null && root.right == null)
            return target == 0;

        return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }
}
