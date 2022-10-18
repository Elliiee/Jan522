import java.util.ArrayList;
import java.util.List;

public class Q545 {
    List<Integer> nodes = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root){
        if (root == null) return nodes;

        nodes.add(root.val);

        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }

    public void leftBoundary(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) return;

        nodes.add(root.val);

        if (root.left == null)
            leftBoundary(root.right);
        else
            leftBoundary(root.left);
    }

    public void rightBoundary(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) return;

        if (root.right == null)
            rightBoundary(root.left);
        else
            rightBoundary(root.right);

        nodes.add(root.val); // node here, add value only after visiting the children
        // this is how it will be a reverse way
    }

    public void leaves(TreeNode root){
        if (root == null) return;

        if (root.left == null && root.right == null){
            nodes.add(root.val);
            return;
        }

        leaves(root.left);
        leaves(root.right);
    }
}
