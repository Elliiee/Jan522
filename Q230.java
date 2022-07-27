import java.util.ArrayList;
import java.util.List;

public class Q230 {
    //the kth small-est element in a bst
    // inorder of bst is naturally sorted
    List<Integer> result = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        inorder(root);

        if (k >= result.size())
            return result.get(result.size()-1);

        return result.get(k-1);
    }

    private void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}
