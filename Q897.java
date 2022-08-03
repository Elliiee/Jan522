import java.util.ArrayList;
import java.util.List;

public class Q897 {
    // increasing order search tree
    public void inorder(TreeNode node, List<Integer> list){
        if (node == null) return;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public TreeNode increasingBST(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        TreeNode dummy = new TreeNode(0);
        TreeNode current = dummy;
        for (int r : result){
            current.right = new TreeNode(r);
            current = current.right;
        }
        return dummy.right;
    }
}
